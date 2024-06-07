# shurulab_crud
기본 게시판의 crud 및 로그인/회원 수정을 연습하기 위한 프로젝트입니다.
# 공통 요구사항
- DB는 MYSQL을 사용해주세요<br>
- DB의 url과 아이디 비밀번호는 카톡으로 보내주신 내용대로 작업해주세요
# 1차 기본 구현 요구사항
1차 과제 제출을 위한 기능 명세서의 기능만 요약하였습니다.
## 회원가입
- [X] 아이디는 이메일형식인지 확인해야합니다.<br>
- [X] 비밀번호의 길이는 최소 8글자로 설정합니다.<br>
- [X] 닉네임의 경우 3-9글자로 특수문자는 금지입니다.<br>
- [X] 프로필 이미지 역시 적용 가능해야합니다
## 로그인
- [x] 이메일 형식인지 검사 이후 로그인이 이루어져야합니다.
# 1차 제출 구현사항
- [X] db는 sql을 사용하여 원하시는 url 도메인과 연결하니였습다.
- [X] 회원가입의 양식은 현재 프로필 이미지 이외 적용 완료 하였고, db뿌리기 및 예외사항 처리 완료하였습니다.
- [X] 로그인 시 검사 까진 완료 되었고, 현재 로그인 구현중입니다.
- [x] 기타 추가사항으로는 스프링 시큐리티 활용하여 비밀번호 암호화를 완료하엿습니다.
# 1차 제출 관련 db관계도
![1차 관계도](https://github.com/park-yina/shurulab_crud/assets/111878820/acc55d26-a363-44ae-82b9-9b1e3fe88d08)
수정사항으로는 db의 테이블이 많아지면, 성능이 떨어지니 이메일은 유저 테이블 내의 데이터로 집어넣고 양식을 검사하기로 하였습니다.
# 2차 미션 관련 구현 사항 체크
2차 과제 미션 제출을 위한 기능 명세서 기준을 요약하였습니다.<br>
## 이미지 처리
- [X] DB에는 경로가 아닌 이미지 즉 blob등에 대해 찾아보고 작업을 진행해야 합니다.
## 게시판 관련 구현사항
- 게시판 이름은 A/B/C/D로 해주세요<br>
- 자유롭게 이미지 한장과 글을 올릴 수 있어야합니다<br>
- 수정 및 삭제는 올린사람만 가능해야합니다<br>
- 게시판 제목 즉 `A`게시판을 클릭하면 글제목 글쓴이 조회수가 떠야합니다.<br>
- 글제목을 클릭시 글의 본문이 나와야합니다.
## 회원 정보 수정
- 비밀번호와 프로필 사진은 변경 가능합니다.<br>
- 닉네임의 경우 변경 가능하나, 중복 검사를 진행해주셔야 합니다.
# 2차 미션 구현 진행사항 체크
- [X] 닉네임 변경시 중복체크하기<br>
- [X] 비밀번호 변경<br>
- [X] 프로필 사진 적용<br>
- [X] 프로필 사진 변경
- [x] 게시판 클릭시 글제목 글쓴이가 나오게 합니다. <br>
- [X] 조회수 기능을 구현합니다.
## 2차 미션 1회 제출(게시판 외 기능 구현 완) 피드백
- [X] 크기가 큰 이미지도 잘 들어가는지 확인해주세요<br>
- [x] blob를 사용하신 경우 exe나 mp4등 사진이 아닌 파일에 대한 예외처리를 해주세요<br>
# 2차 미션 관련 경험 트러블 슈팅 정리
- [X] 엔티티 관리<br>
초반에 게시물 엔티티를 분리하지 않은 결과, 코드가 복잡해지는 것을 보고 List로 따로 뺀 뒤 ManyToOne으로 대응시킴<br>
- [X] EL1078E에러(이미지 큰 사진 한정)<br>
크기가 큰 이미지의 경우 blob를 처리하는 과정에서 글자가 길어져서인지 에러 발생. 작은 프로필은 업로드 잘됨<br>
타임리프의 문자열 에러로 인코딩 과정에서 발생하는 오류임을 확인하고, ImgUtil이라는 클래스를 통해 미리 사진을 줄여 업로드하도록 코드를 수정하였습니다.<br>
- [] 닉네임 변경 이후 게시물 수정 오류<br>
닉네임을 변경 시 본인에 대한 식별 오류가 발생하여, 자신이 닉네임 변경 이전에 작성한 글에 대한 삭제나 수정이 안되는 버그를 발견하여 수정중입니다.
