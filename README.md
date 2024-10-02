# week2-axios-test
## API 명세
### 1. POST /products
#### Request
```json
{
    "name": "상품명",
    "content": "상품 설명",
    "price": 10000
}
```
#### Response
```json
{
    "id": 1,
    "name": "상품명",
    "content": "상품 설명",
    "price": 10000
}
```

### 2. GET /products
#### Request
None
#### Response
```json
[
    {
        "id": 1,
        "name": "상품명",
        "content": "상품 설명",
        "price": 10000
    },
    {
        "id": 2,
        "name": "상품명",
        "content": "상품 설명",
        "price": 10000
    }
]
```


# AWS EC2 입력한 커멘드
```shell
# git 설치 및 소스 코드 다운
sudo yum install git -y
git clone https://github.com/doit-web-study/week2-axios-test.git

# JDK 17 설치
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.rpm
sudo rpm -ivh jdk-17_linux-x64_bin.rpm

# iptables 설치 및 포트포워딩 설정
sudo yum install iptables -y 
sudo iptables -t nat -A PREROUTING -i enX0 -p tcp --dport 80 -j REDIRECT --to-port 8080

# 소스 빌드 및 실행
cd week2-axios-test/ # 소스코드 디렉토리로 이동
./gradlew build # 빌드
sudo nohup java -jar build/libs/week2-axios-test-0.0.1-SNAPSHOT.jar & # 실행
```

