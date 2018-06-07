# jwtGuide

# How to run
    Copy repository 
        git clone https://github.com/sunilchauhan1/jwtExamples.git 
    Go to folder java/Demo
        cd jwtExamples/java/demo/
    Run Application    
        ./gradlew bootRun
    To Encode sample claim with hmac algorithm use following url
        http://localhost:8080/token/encode/hmac256
    To Encode sample claim with rsa algorithm use following url    
        http://localhost:8080/token/encode/rsa256
    To Verify sample claim with hmac algorithm use following url  
        http://localhost:8080/token/verify/hmac256
