# Instagram
# 📷 클론 코딩
Spring Boot + React를 사용한 클론 코딩 프로젝트

<br/>
<br/>
<br/>

🎮 클론 기능
-------------  

- 로그인 및 회원가입 기능을 통해 인스타그램 클론 서비스를 이용하실 수 있습니다.
- 메인화면에서 다른 사람이 올린 글을 볼 수 있습니다.
- 글쓰기 기능을 통해 남들에게 내가 찍은 사진을 공유할 수 있습니다.
- 좋아요 기능으로 다른 사람 글을 추천해보세요.
- DM기능 추가예정

<br/>
<br/>

🤔 Team
-------------  
[Front-End] 박태순, 천누리 (https://github.com/hh99-Clone-Project/Frontend.git)  
[Back-End] 장재영, 정우창, 정의현 (https://github.com/hh99-Clone-Project/backend)

<br/>
<br/>

🤔 프로젝트 개요
-------------  
<ul style="list-style-type: disc;" data-ke-list-type="disc">
<li><b>진행 날짜 - 2022.04.15 ~ 2021.04.21</b></li>
<!-- <li><b>목적 - 팀원들과 함께, 백엔드와 프론트 엔드의 역할을 맡아 클론 코딩을 해보자!!!</b></li> -->
<li><b>필수 포함 사항</b></li>
</ul>

<br/>
<br/>


<br/>
<br/>


😀 사용한 패키지 및 CSS
-----------------
<!-- - **Express**  　　　=> node.js의 웹 프레임워크  
- **mongoose**　　=> node.js에서 비관계형 데이터베이스인 Mongo DB를 사용해보자  
- **eslint**　　　　=> node.js에서 팀 단위 협업시, 문법 검사를 해보자  
- **prettier**　　　=> node.js에서 팀 단위 협업시, 코딩 스타일을 통일해보자  
- **husky**　　=> node.js에서 git hook을 손쉽게 관리해보자 
- **lint-staged**　　=> node.js에서 Git에 staged 상태인 파일만 lint해주자  
- **cors**　　=> node.js에서 cors 문제를 해결해보자  
- **nodemon**　　=> node.js에서 파일 수정시 자동으로 서버를 내렸다가 올려보자  
- **bcrypt**　　=> node.js에서 데이터베이스에 저장할 비밀번호를 암호화 해보자  
- **multer**　　=> node.js에서 프론트 엔드에서 보내주는 이미지 데이터를 받아보자   
- **multer-s3**　　=> node.js에서 AWS S3에 접근하여 이미지 데이터를 업로드 해보자   
- **aws-sdk**　　=> node.js에서 AWS를 사용해보자      
- **jwt**　　=> node.js에서 jwt 토큰을 이용한 로그인 기능을 구현해보자        
 -->

<br/>
<br/>

😎 폴더 구조
-----------------  

<!-- <br/>

```bash
instagram_clonCording
├─ node_modules
│  
├─ .vscode
│  
├─ middleWare
│  └─ verifiacation
│     └─ verify_middleWare.js
│  
│  
├─ models
│  ├─ schema
│  │  └─ board_schema.js
│  │  └─ comment_schema.js
│  │  └─ like_schema.js
│  │  └─ user_schema.js
│  │
│  └─ connectDB.js
│  
├─ controller
│  ├─ board_controller
│  │  ├─ board_service
│  │  │  └─ board_service.js
│  │  └─ board_controller.js
│  │
│  ├─ login_controller
│  │  ├─ login_service
│  │  │  └─ login_service.js
│  │  └─ login_controller.js
│  │
│  ├─ main_controller
│  │  ├─ main_service
│  │  │  └─ main_service.js
│  │  └─ main_controller.js
│  │
│  ├─ profile_controller
│  │  ├─ profile_service
│  │  │  └─ profile_service.js
│  │  └─ profile_controller.js
│  │
│  └─ register_controller
│     ├─ register_service
│     │  └─ register_service.js
│     └─ register_controller.js
│  
└─ app.js
└─ package-lock.json
└─ package.json
└─ awsconfig.json
└─ .prettierrc.json
└─ .eslintrc.json
```

<br/> -->
<br/>
<br/>

🤭 Instagram Clone Cording ERD
-----------------

<br/>
<br/>

<!-- <p align="center"><img src="https://user-images.githubusercontent.com/52685665/114116695-15486000-9920-11eb-834b-ac8d6e3bef70.png"></p> -->

<br/>
<br/>

🤭 API
-----------------

<br/>
<br/>

<!-- <p align="center"><img src="https://user-images.githubusercontent.com/52685665/114117529-e03d0d00-9921-11eb-9d18-ffa195f36449.png"></p> -->

<br/>
<br/>

🤩 업무 분담
-----------------

* 로그인 및 회원가입 기능
* 메인 페이지 글 보여주기 기능
* 좋아요 기능
* 글쓰기 및 이미지 업로드 기능

<br/>
<br/>

🤭 이번 프로젝트를 하며 새롭게 배운 것
-----------------
<!-- 1.  백엔드 단 구조 잡기 (mvc 구조)  
2.  multer를 사용하여 이미지를 프론트 엔드에서 받아오고,  그것을 AWS S3에 올려보기  
3.  bcrypt를 사용하여 비밀번호를 암호화하여 저장하고, 로그인시 비교하기  
4.  authorization 인증 토큰을 헤더로 담아오기   -->

<br/>
<br/>

🤭 multer와 AWS 사용하기
-----------------

<br/>
<br/>

<!-- multer를 사용하여 Amazon S3에 이미지를 업로드할 수 있습니다.  
이미지 같은 경우는 용량도 크니, 아무래도 Amazon에서 빌리는 편이 더 좋겠죠?  

단, 이미 Amazon S3 bucket이 만들어진 상태여야 하고  
미리 awsconfig.json에 aws 키값을 받아서 입력해야 합니다.  

물론, 저는 노출 방지를 위해서 내용을 빼놨습니다.  

프론트에서 데이터를 받기 위해서는 프론트 header에서 'Content-Type': 'multipart/form-data'를 설정해주셔야 합니다.  
그렇지 않으면 null로 반환됩니다!  

예전에는 회원 로그인 토큰값을 body에 담아서 받았는데, multipart/form-data의 경우 body값을 제대로 불러올 수 없습니다.  
따라서 header에 담아서 토큰값을 보냈습니다.  

<p align="center"><img src="https://user-images.githubusercontent.com/52685665/114110890-8af9ff00-9913-11eb-98e6-97c4e743b9f0.png"></p> -->

<br/>
<br/>


🤭 bcrypt 암호화 하기 및 비교하기
-----------------
<!--
<br/>
<br/>

bcrypt는 미국 NSA에서 설계한 암호화 해시 함수입니다.

기존의 SHA가 해쉬속도가 너무 빠른 탓에 레인보우 테이블을 만들 수 있는 시간이 단축된다는 문제점이 있었습니다.

bcrypt는 blowfish라는 기법이 사용되어서 원하는 만큼 해쉬 속도를 조절할 수 있다는 장점이 있었습니다.  
그래서 이번 프로젝트에서는 bcrypt로 암호화를 진행하였습니다.

만약, 보안에 더 민감한 곳이라면 scrypt나, Argon2id를 사용해야 합니다.

<br/>
<br/>

mongoDB 스키마에 암호화 걸기

<p align="center"><img src="https://user-images.githubusercontent.com/52685665/114111464-0e682000-9915-11eb-9cbf-9ad124b4b165.png"></p>

<br/>
<br/>

bcrypt로 암호화된 비밀번호와 입력된 비밀번호 비교하기

<p align="center"><img src="https://user-images.githubusercontent.com/52685665/114111532-348dc000-9915-11eb-8b7d-abbc9bf32cc6.png"></p>


<br/>
<br/> -->

🛠 이번 프로젝트에서 보완하거나 아쉬웠던 점
-----------------  

<!-- 아무래도 기간이 1주일 정도밖에 되지 않아서, 인스타그램의 다양한 기능을 만들지 못한게 아쉽습니다.   

예를 들어 인스타그램에서 보이는 친구 추천 기능이라던가, 친구 추가하고 사진을 보는 기능은 시간상 넣지 못했습니다.  
다음에 시간이 넉넉할 때 해당 기능을 구현해 보면 좋겠다는 생각이 들었습니다.   -->


<br/>
<br/>
