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
        <h2>회원 목록</h2>
      </div>

      <div class="row">
        <div class="col">
          <a href="/member/signup.do" class="btn btn-primary float-end">회원 등록</a>
        </div>
      </div>
      <hr class="my-4">
      <div>
        <table class="table">
          <thead>
            <tr>
              <th>아이디</th>
              <th>이름</th>
              <th>이메일</th>
              <th>가입일자</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${requestScope.list}" var="member"> <%-- requestScope 생략가능 --%>
            <tr>
              <td><a href="/member/detail.do?id=${member.id}">${member.id}</a></td>
              <td>${member.name}</td>
              <td><a href="mailto:${member.email}">${member.email}</a></td> <%-- "mailto: 클릭했을때 메일보내기 기능 --%>
              <td>${member.regdate}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
          <li class="page-item disabled"><a class="page-link"
            href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
          </a></li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item active" aria-current="page"><a
            class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item"><a class="page-link" href="#"
            aria-label="Next"> <span aria-hidden="true">&raquo;</span>
          </a></li>
        </ul>
      </nav>
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