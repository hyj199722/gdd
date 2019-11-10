<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>

    <title>AdminLTE 2 | Dashboard</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <link rel="stylesheet" href="/assets/bower_components/css/bill_select.css">

</head>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"></jsp:include>
    <jsp:include page="../includes/menu.jsp"></jsp:include>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                运输货物编辑
                <small>Item Query</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>运输货物编辑</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult.status!=null}">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h4><i class="icon fa fa-ban"></i> Alert!</h4>
                                ${baseResult.message}
                        </div>
                    </c:if>


                    <div class="box">
                        <form class="form-horizontal" action="/itemdrive_select" method="get" id="ship_form">
                            <c:if test="${status==1}"><div class="row" style="padding-left: 20px; padding-top: 10px">
                                <button type="submit" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>卸货</button>&nbsp&nbsp&nbsp
                                <button id="item_ship" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>发车</button>&nbsp&nbsp&nbsp
                            </div>
                            </c:if>
                            <!-- /.box-header -->
                            <div class="box-body table-responsive no-padding">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <c:if test="${status==1}"><th><input type="checkbox" class="minimal icheck_master"></th></c:if>
                                        <th>货物单编号</th>
                                        <th>品名</th>
                                        <th>货号</th>
                                        <th>件数</th>
                                        <th>重量</th>
                                        <th>体积</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${items}" var="item">
                                        <tr>
                                            <c:if test="${status==1}"> <td><input name="unload" type="checkbox" class="minimal" value="${item.itemId};${item.waybillId}"></td></c:if>
                                            <td>${item.waybillId}</td>
                                            <td>${item.itemName}</td>
                                            <td>${item.itemId}</td>
                                            <td>${item.itemNum}</td>
                                            <td>${item.itemWeight}</td>
                                            <td>${item.itemSize}</td>


                                        </tr>
                                    </c:forEach>

                                    </tbody>


                                </table>
                                <input type="hidden" name="contractId" value="${contractId}">
                            </div>
                        </form>
                        <c:if test="${status==1}"><form class="form-horizontal" action="/itemdrive_select" method="get">
                            <div class="box-body col-sm-12 page">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">起点站：</label>
                                    <input type="text"  name="waybillBegin" class=" col-sm-2 " placeholder="请输入起点站">
                                    <label class="col-sm-2 control-label">终点站：</label>
                                    <input type="text"  name="waybillEnd" class=" col-sm-2 " placeholder="请输入终点站">
                                    <input type="hidden" name="contractId"value="${contractId}">
                                    <button type="submit" class="btn btn-info">查询</button>
                                </div>
                            </div>
                        </form>
                        <form class="form-horizontal" action="/itemdrive_select" method="get">
                            <div class="row" style="padding-left: 20px; padding-top: 10px">
                                <button type="submit" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>装货</button>&nbsp&nbsp&nbsp</c:if>
                                <a href="/contract_edit?contractId=${contractId}" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-undo"></i>返回</a>&nbsp&nbsp&nbsp
                                <c:if test="${status==1}"></div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master"></th>
                                    <th>货物单编号</th>
                                    <th>品名</th>
                                    <th>货号</th>
                                    <th>件数</th>
                                    <th>重量</th>
                                    <th>体积</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="item">
                                    <tr>
                                        <td><input name="checkbox" type="checkbox" class="minimal" value="${item.itemId};${item.waybillId}"></td>
                                        <td>${item.waybillId}</td>
                                        <td>${item.itemName}</td>
                                        <td>${item.itemId}</td>
                                        <td>${item.itemNum}</td>
                                        <td>${item.itemWeight}</td>
                                        <td>${item.itemSize}</td>


                                    </tr>
                                </c:forEach>

                                </tbody>


                            </table>
                            <input type="hidden" name="contractId" value="${contractId}">
                        </div>
                        </form>
                        <%--分页文字信息--%>
                        <div class="row" >
                            <%--分页文字信息--%>
                            <div class="col-md-6">
                                当前第${pageInfo.pageNum}页，总${pageInfo.pages}页，总共${pageInfo.total}条记录
                            </div>
                            <%--分页条信息--%>
                            <div class="col-md-6" style="padding-left: 150px">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination">
                                        <li><a href="/itemdrive_select?pn=1&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&contractId=${contractId}">首页</a> </li>
                                        <%--如果有上一页，则可以通过减一操作移动，且有<符号&laquo，否则连点<的符号也没有，也就不能移动上一页--%>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li>
                                                <a href="/itemdrive_select?pn=${pageInfo.pageNum-1}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&contractId=${contractId}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                </a>
                                            </li>
                                        </c:if>


                                        <%--如果是当前页，则显示高亮--%>
                                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                                            <c:if test="${page_Num==pageInfo.pageNum}">
                                                <li class="active"><a href="#">${page_Num}</a></li>
                                            </c:if>
                                            <c:if test="${page_Num!=pageInfo.pageNum}">
                                                <li><a href="/itemdrive_select?pn=${page_Num}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&contractId=${contractId}">${page_Num}</a></li>
                                            </c:if>

                                        </c:forEach>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li>
                                                <a href="/itemdrive_select?pn=${pageInfo.pageNum+1}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&contractId=${contractId}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>

                                        <li><a href="/itemdrive_select?pn=${pageInfo.pages}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&contractId=${contractId}">末页</a> </li>
                                        <form style="float: left" action="/waybill_select">
                                            <input type="text" name="pn" style="height:33px;width: 50px">
                                            <input hidden type="text" name="waybillId" value="${waybillId}" style="height:33px;width: 50px">
                                            <input hidden type="text" name="billType" value="${billType}" style="height:33px;width: 50px">
                                            <input hidden type="text" name="billStatus" value="${billStatus}" style="height:33px;width: 50px">
                                            <input hidden type="text" name="timeRange" value="${timeRange}" style="height:33px;width: 50px">
                                            <input type="submit" value="跳转" class="btn btn-primary">
                                        </form>


                                    </ul>
                                </nav>
                            </div>


                        </div>
                        <!-- /.box-body -->
                        </c:if>

                    </div>
                </div>
            </div>

        </section>
    </div>
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.2.0
        </div>
        <strong>Copyright &copy; 2019-2019 <a href="#">We can resolve it</a>.</strong> All rights
        reserved.
    </footer>

</div>


<jsp:include page="../includes/footer.jsp"></jsp:include>
<sys:modal />
<script>

    $("#item_ship").bind("click",function () {
        $("#modal-message").html("发车后将不能再装货，您确定要发车吗？");
        $("#modal-default").modal("show");
        $("#btnModalOk").bind("click", function () {
            $("#modal-default").modal("hide");
            $("#ship_form").attr("action","/item_ship")
            $("#ship_form").submit();

        });
    });


</script>
</body>
</html>