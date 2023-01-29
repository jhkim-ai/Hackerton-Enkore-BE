# Enkore (Back-End Server)

<hr>

## [환경설정 및 실행]

### 1. 버전
```Intellij IDEA```, ```Spring boot v.2.7.8```, ```JDK 11```

### 2. 설치
 (1) mac - _terminal_ [(공식가이드)](https://github.com/mdogan/homebrew-zulu)
```
 $ brew tap mdogan/zulu       # Homebrew에 zulu repository 등록 
 $ brew install zulu-jdk11    # jdk11 설치
 $ java -version              # jdk 버전 확인
 ```
(2) Windows - _cmd_ [(설치하기)](https://www.azul.com/downloads/?package=jdk#download-openjdk)
```
 $ java -version              # jdk 버전 확인
```

### 3. Intellij IDEA 환경설정 [(참고)](https://youngjinmo.github.io/2020/12/change-jdk-intellij/)
> 1. Intellj에서 프로젝트 열기
> 2. Project Structure 이동 (cmd + ;)
> 3. Project settings -> Project -> Project SDK 에서 Zulu-11 저용
> 4. [Gradle Reload](https://www.jetbrains.com/idea/guide/tutorials/working-with-gradle/syncing-and-reloading/)

### 4. Server 실행
```/src/main/com/koscom/enkore/EnkoreApplication.java```
파일 run 


