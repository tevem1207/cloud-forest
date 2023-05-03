<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<html>
  <head>
    <head>
      <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous"
      />
      <link
        rel="stylesheet"
        href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css"
      />
      <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <title>클숲</title>
  </head>

  <body>
    <main>
      <h1>클숲</h1>
      <div class="posts-container">
        <% for (int i = 0; i < 5; i++) { %>
        <div class="post">
          <div class="feature-icon bg-primary bg-gradient">
            <i class="fi fi-rr-user"></i>
          </div>
          <h2><%=i+1%>번째 외침</h2>
          <p>
            건영님 노트북 소리 너무 커요. 줄여주세요... 너무 신경쓰여서 여기 글
            씁니다.
          </p>
          <a href="#" class="icon-link">
            Call to action
            <svg class="bi" width="1em" height="1em">
              <use xlink:href="#chevron-right"></use>
            </svg>
          </a>
        </div>
        <%}%>
        <a href="create/">글 생성하기</a>
      </div>
    </main>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
