
package com.online.taxi.msg.application;

import com.online.taxi.dto.SmsSendRequest;
import com.online.taxi.dto.SmsTemplateDto;
import com.online.taxi.msg.constants.SmsEnum;
import com.online.taxi.msg.domain.sms.client.AliYunSmsClient;
import com.online.taxi.msg.domain.sms.entity.Sms;
import com.online.taxi.msg.domain.sms.factory.SmsFactory;
import com.online.taxi.msg.domain.sms.service.SmsDomainService;
import com.online.taxi.msg.domain.sms.service.SmsTplDomainService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class SMSApplicationService {

    @Autowired
    private SmsTplDomainService smsTplDomainService;

    @Autowired
    private SmsDomainService smsDomainService;

    @Autowired
    private AliYunSmsClient aliYunSmsClient;

    // 缓存模板
    private Map<String, String> templateMaps = new HashMap<>();

    public int sendSms(SmsSendRequest request) {
        for (String phoneNumber : request.getReceivers()) {
            List<SmsTemplateDto> templates = request.getData();
            for (SmsTemplateDto template : templates) {
                if (!templateMaps.containsKey(template.getId())) {
                    templateMaps.put(template.getId(), smsTplDomainService.findByTemplateId(template.getId()).getContent());
                }

                String content = templateMaps.get(template.getId());
                for (Map.Entry<String, Object> entry : template.getTemplateMap().entrySet()) {
                    content = StringUtils.replace(content, "{" + entry.getKey() + "}", "" + entry.getValue());
                }
                Sms sms = SmsFactory.create(phoneNumber, content);
                try {
                    int result = send(phoneNumber, template.getId(), template.getTemplateMap());

                    if (result != SmsEnum.OK.getCode()) {
                        throw new Exception("Failed sent SMS.");
                    }
                } catch (Exception e) {
                    sms.sendFailed();
                    log.error("Send（" + template.getId() + "）failed：" + phoneNumber, e);
                } finally {
                    smsDomainService.save(sms);
                }
            }
        }
        return 0;
    }

    private int send(String phoneNumber, String templateId, Map<String, ?> map) {
        JSONObject param = new JSONObject(map);
        return aliYunSmsClient.sendMsg(phoneNumber, templateId, param.toString());
    }
}
