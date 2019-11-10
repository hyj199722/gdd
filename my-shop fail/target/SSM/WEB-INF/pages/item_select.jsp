<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

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
                新到货物
                <small>Item Query</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>新到货物查询</li>
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
                        <div class="box-header">

                            <h2></h2>
                            <h3 class="box-title">查询条件</h3>
                            <form class="form-horizontal" action="#" method="post">
                                <div class="box-body col-sm-12 page">
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label">货运单编号：</label>
                                    </label><input type="text" class="col-sm-2" placeholder="请输入编号"name="">
                                    <label class="col-sm-2 control-label">发货客户：</label>
                                    </label><input type="text" class="col-sm-2" placeholder="请输入名称"name="">
                                </div>

                                        <div class="form-group">

                                            <label class="col-sm-2 control-label">收货客户：</label>
                                            </label><input type="text" class="col-sm-2" placeholder="请输入名称"name="">
                                        </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">起点站：</label>
                                        </label><input type="text" class="col-sm-2" placeholder="请输入名称"name="">
                                        <label class="col-sm-2 control-label">终点站：</label>
                                        </label><input type="text" class="col-sm-2" placeholder="请输入名称"name="">
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">时间范围:&nbsp&nbsp&nbsp</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-clock-o"></i>
                                            </div>
                                            <input style="width: 200px" name="timeRange" type="text" class="form-control pull-left" id="reservation">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-info pull-right">查询</button>
                                    </div>

                                    </div>

                            </form>

                        </div>

                        <!-- /.box-header -->

                        <div class="box-body table-responsive no-padding">
                            <div class="row" style="padding-left: 20px; padding-top: 10px">
                            <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa  fa-cubes"></i>到货</a>&nbsp&nbsp&nbsp
                        </div>
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master"></th>
                                    <th>货运回执单编号</th>
                                    <th>发货客户</th>
                                    <th>发货客户电话</th>
                                    <th>收货客户</th>
                                    <th>收货客户电话</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users}" var="users">
                                    <tr>
                                        <td><input id="${users.id}" type="checkbox" class="minimal"></td>
                                        <td>${users.username}</td>
                                        <td>${users.email}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>

                                    </tr>
                                </c:forEach>

                                </tbody>

                            </table>
                        </div>
                        <%--分页信息--%>
                        <div class="row" >
                            <%--分页文字信息--%>
                            <div class="col-md-6">
                                当前第${pageInfo.pageNum}页，总${pageInfo.pages}页，总共${pageInfo.total}条记录
                            </div>
                            <%--分页条信息--%>
                            <div class="col-md-6" style="padding-left: 150px">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination">
                                        <li><a href="/driver_receipt_select?pn=1">首页</a> </li>
                                        <%--如果有上一页，则可以通过减一操作移动，且有<符号&laquo，否则连点<的符号也没有，也就不能移动上一页--%>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li>
                                                <a href="/driver_receipt_select?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
                                                <li><a href="/driver_receipt_select?pn=${page_Num}">${page_Num}</a></li>
                                            </c:if>

                                        </c:forEach>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li>
                                                <a href="/driver_receipt_select?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>

                                        <li><a href="/driver_receipt_select?pn=${pageInfo.pages}">末页</a> </li>
                                        <form style="float: left" action="/driver_receipt_select">
                                            <input type="text" name="pn" style="height:33px;width: 50px">
                                            <input type="submit" value="跳转" class="btn btn-primary">
                                        </form>


                                    </ul>
                                </nav>
                            </div>

                        </div>
                        <!-- /.box-body -->

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
<script>
    $(function () {

        //Date range picker
        $('#reservation').daterangepicker()
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' })
        //Date range as a button
        $('#daterange-btn').daterangepicker(
            {
                ranges   : {
                    'Today'       : [moment(), moment()],
                    'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
                    'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                    'This Month'  : [moment().startOf('month'), moment().endOf('month')],
                    'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                },
                startDate: moment().subtract(29, 'days'),
                endDate  : moment()
            },
            function (start, end) {
                $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
            }
        )

        //Date picker
        $('#datepicker').datepicker({
            autoclose: true
        })


        //Timepicker
        $('.timepicker').timepicker({
            showInputs: false
        })
    })
</script>
</body>
</html>