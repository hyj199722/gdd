<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

    <title>首页</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>

</head>


<body class="hold-transition skin-blue sidebar-mini" >
<div class="wrapper ">
   <jsp:include page="../includes/nav.jsp"></jsp:include>
   <jsp:include page="../includes/menu.jsp"></jsp:include>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper"style="background:url('/assets/dist/img/bg.jpg') ;
  background-repeat: no-repeat;
    background-size: 100% 100%;
    -moz-background-size: 100% 100%;" >

    </div>
        <footer class="main-footer" style="background-color: #3c8dbc">
            <div class="pull-right hidden-xs">
                <b>Version</b> 1.2.0
            </div>
            <strong>Copyright &copy; 2019-2019 We can resolve it.</strong> All rights
            reserved.
        </footer>

</div>



<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>