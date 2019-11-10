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
                货物单编辑
                <small>WayBill  Query</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>货物单编辑</li>
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


                            <form class="form-horizontal" id="item_form" action="/item_alter" method="post">
                                <div class="box-body col-sm-12 page">

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">货运单编号：</label>
                                        <input type="text" name="waybillId" readonly value="${item.waybillId}" class="col-sm-2" placeholder="请输入编号">

                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">货物名称：</label>
                                        <input type="text" name="itemName" <c:if test="${item.itemName!=null}">value="${item.itemName}" </c:if> class="col-sm-2" placeholder="请输入名称">
                                        <label class="col-sm-2 control-label">货物编号：</label>
                                        <input type="text" name="itemId" <c:if test="${item.itemId!=null}">value="${item.itemId}" </c:if> class="col-sm-2" placeholder="请输入编号">
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"> 包装：</label>
                                        <select name="itemWrap" class="col-sm-2 select">
                                            <option <c:if test="${item.itemWrap==0}">selected</c:if>  value="0">请选择</option>
                                            <option <c:if test="${item.itemWrap==1}">selected</c:if> value="1">纸箱</option>
                                            <option <c:if test="${item.itemWrap==2}">selected</c:if> value="2">袋装</option>
                                            <option <c:if test="${item.itemWrap==3}">selected</c:if> value="3">桶装</option>
                                            <option <c:if test="${item.itemWrap==4}">selected</c:if> value="4">其他</option>
                                        </select>
                                        <label class="col-sm-2 control-label"> 件数：</label>
                                        <input type="text" name="itemNum" <c:if test="${item.itemNum!=null}">value="${item.itemNum}" </c:if> class="col-sm-2" placeholder="请输入件数">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">重量（千克）：</label>
                                        <input type="text" name="itemWeight" <c:if  test="${item.itemWeight!=null}">value="${item.itemWeight}" </c:if> class="col-sm-2" placeholder="请输入重量">
                                        <label class="col-sm-2 control-label">体积（立方米）：</label>
                                        <input type="text" name="itemSize" <c:if test="${item.itemSize!=null}">value="${item.itemSize}" </c:if> class="col-sm-2" placeholder="请输入体积">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">货物价值（元）：</label>
                                        <input type="text" name="itemValue" <c:if test="${item.itemValue!=null}">value="${item.itemValue}" </c:if>class="col-sm-2" placeholder="请输入价格">
                                        <label class="col-sm-2 control-label">保险费率：</label>
                                        <input type="text" name="itemInsurance" <c:if test="${item.itemInsurance!=null}">value="${item.itemInsurance}" </c:if>class="col-sm-2" placeholder="请输入费率">
                                    </div>
                                    <div class="form-group">

                                        <label class="col-sm-2 control-label"> 计价方式：</label>
                                        <select name="itemPay" class="col-sm-2 select">
                                            <option <c:if test="${item.itemPay==0}">selected</c:if> value="0">请选择</option>
                                            <option <c:if test="${item.itemPay==1}">selected</c:if> value="1">重量</option>
                                            <option <c:if test="${item.itemPay==2}">selected</c:if> value="2">件数</option>

                                        </select>
                                        <label class="col-sm-2 control-label"> 运输费：</label>
                                        <input type="text" class="col-sm-2" <c:if test="${item.itemShip!=null}">value="${item.itemShip}" </c:if> name="itemShip" placeholder="请输入价钱">

                                    </div>

                                    <div class="row" style="padding-left: 50px; padding-top: 10px">
                                        <button  type="post" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>修改</button>&nbsp&nbsp&nbsp
                                        <button id="item_delete" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</button>&nbsp&nbsp&nbsp
                                        <a href="/item_add?waybillId=${item.waybillId}" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-undo"></i>返回</a>&nbsp&nbsp&nbsp
                                    </div>
                                </div>
                            </form>

                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>货物名称</th>
                                    <th>编号</th>
                                    <th>包装</th>
                                    <th>件数</th>
                                    <th>重量</th>
                                    <th>体积</th>
                                    <th>货物价值</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="item">
                                    <tr>
                                        <td>${item.itemName}</td>
                                        <td> <a href="/item_edit?itemId=${item.itemId}&waybillId=${item.waybillId}" >${item.itemId}</a></td>
                                        <td><c:if test="${item.itemWrap ==1}" >纸箱</c:if>
                                            <c:if test="${item.itemWrap ==2}" >袋装</c:if>
                                            <c:if test="${item.itemWrap ==3}" >桶装</c:if>
                                            <c:if test="${item.itemWrap ==4}" >其他</c:if></td>
                                        <td>${item.itemNum}</td>
                                        <td><c:if test="${item.itemWeight!=null}" >${item.itemWeight}</c:if></td>
                                        <td><c:if test="${item.itemSize!=null}" >${item.itemSize}</c:if></td>
                                        <td><c:if test="${item.itemValue!=null}" >${item.itemValue}</c:if></td>
                                    </tr>
                                </c:forEach>

                                </tbody>


                            </table>
                        </div>
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
                                        <li><a href="/item_edit?pn=1&waybillId=${item.waybillId}&itemId=${item.itemId}">首页</a> </li>
                                        <%--如果有上一页，则可以通过减一操作移动，且有<符号&laquo，否则连点<的符号也没有，也就不能移动上一页--%>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li>
                                                <a href="/item_edit?pn=${pageInfo.pageNum-1}&waybillId=${item.waybillId}&itemId=${item.itemId}" aria-label="Previous">
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
                                                <li><a href="/item_edit?pn=${page_Num}&waybillId=${item.waybillId}&itemId=${item.itemId}">${page_Num}</a></li>
                                            </c:if>

                                        </c:forEach>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li>
                                                <a href="/item_edit?pn=${pageInfo.pageNum+1}&waybillId=${item.waybillId}&itemId=${item.itemId}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>

                                        <li><a href="/item_edit?pn=${pageInfo.pages}&waybillId=${item.waybillId}&itemId=${item.itemId}">末页</a> </li>
                                        <form style="float: left" action="/item_edit">
                                            <input type="text" name="pn" style="height:33px;width: 50px">
                                            <input hidden type="text" name="waybillId" value="${item.waybillId}" style="height:33px;width: 50px">
                                            <input hidden type="text" name="itemId" value="${item.itemId}" style="height:33px;width: 50px">
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
<sys:modal />
<script>

    $("#item_delete").bind("click",function () {
        $("#modal-message").html("确认删除当前物品？");
        $("#modal-default").modal("show");
        $("#btnModalOk").bind("click", function () {
            $("#modal-default").modal("hide");
            $("#item_form").attr("action","/item_delete")
            $("#item_form").submit();
        });
    });


</script>
</body>
</html>