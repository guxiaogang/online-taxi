### Generate private key and public key
#### 1, generate keystore
keytool -genkeypair -alias online-taxi-rsa -keyalg RSA -keypass 123456 -keystore key.jks -storepass 123456 -keystore rsa.jks 

keytool -list -v -keystore rsa.jks

keytool -list -rfc -keystore rsa.jks -storepass 123456

#### 2, export public key
keytool -list -rfc --keystore rsa.jks | openssl x509 -inform pem -pubkey

### Test
#### 1 Authorization Code
##### 1.1 Get Authorization Code
http://localhost:8301/oauth/authorize?client_id=browser&response_type=code&scope=all&redirect_uri=http://www.baidu.com

##### 1.2 Generate Token
http://localhost:8301/oauth/token?client_id=browser&client_secret=secret&grant_type=authorization_code&code=VsrDVm&redirect_uri=http://www.baidu.com

#### Implicit
##### 1.1 Generate Token
http://localhost:8301/oauth/authorize?client_id=browser&response_type=token&scope=all&redirect_uri=http://www.baidu.com

#### Password
http://localhost:8301/oauth/token?client_id=browser&client_secret=secret&grant_type=password&username=test&password=test

#### Client Credentials
http://localhost:8301/oauth/token?client_id=browser&client_secret=secret&grant_type=client_credentials