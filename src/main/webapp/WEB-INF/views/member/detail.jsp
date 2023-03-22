<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Yorizori Cookbook</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
  rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
<%--웹어플리케이션 절대경로 /로 등록해주었음 웬만하면 절대경로로써주자 --%>
</head>

<body>
  <%-- Navigation--%>
  <jsp:include page="/WEB-INF/views/include/nav.jsp" />

  <%-- Section--%>
  <section class="py-5">
    <div class="container">

        <div class="page-header">
      <h2>회원 상세</h2>
    </div>
    
    <div>
      <label for="name">이름</label> <input type="text" id="name"
        name="name" class="form-control" value="<c:out value=`${member.name}`/>" readonly>
    </div>
    <div>
      <label for="userid">아이디</label> <input type="text" id="userid"
        name="userid" class="form-control" value="<c:out value=`${member.id}`/>" readonly>
    </div>
    <div>
      <label for="password">비밀번호</label> <input type="text" id="password"
        name="password" class="form-control" value="<c:out value=`${member.password}`/>" readonly>
    </div>
    <div>
      <label for="age">나이</label> <input type="text" id="age"
        name="age" class="form-control" value="<c:out value=`${member.age}`/>" readonly>
    </div>
    <div>
      <label for="email">이메일</label> <input type="text" id="email"
        name="email" class="form-control" value="<c:out value=`${member.email}`/>" readonly>
    </div>
    <div>
      <label for="regdate">가입일자</label> <input type="text" id="regdate"
        name="regdate" class="form-control" value="<c:out value=`${member.regdate}`/>" readonly>
    </div>
   
    <div class="row">
      <div class="col">
        <button class="w-100 btn btn-primary btn-lg"
          onclick="#" type="button">회원정보 수정</button>
      </div>
      <div class="col">
        <button class="w-100 btn btn-secondary btn-lg" onclick="" type="button">회원 목록</button>
      </div>
    </div>
    </div>
  </section>
  <%-- Footer--%>
  <jsp:include page="/WEB-INF/views/include/footer.jsp" />

  <!-- Bootstrap core JS-->
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="/js/scripts.js"></script>
</body>

</html>