1, generate keystore
keytool -genkeypair -alias online-taxi-rsa -keyalg RSA -keypass 123456 -keystore key.jks -storepass 123456 -keystore rsa.jks
keytool -list -v -keystore rsa.jks
keytool -list -rfc -keystore rsa.jks -storepass 123456

2, export public key
keytool -list -rfc --keystore rsa.jks | openssl x509 -inform pem -pubkey