<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/assets/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">功能菜单</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>用户管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user_list"><i class="fa fa-circle-o"></i> 用户列表</a></li>
                    <li><a href="/user_from"><i class="fa fa-circle-o"></i> 用户管理</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>票据管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/bill_add"><i class="fa fa-circle-o"></i> 票据分发</a></li>
                    <li><a href="/bill_select"><i class="fa fa-circle-o"></i> 票据查询</a></li>
                    <li><a href="/bill_state"><i class="fa fa-circle-o"></i> 票据销核</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>接货管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/waybill_add"><i class="fa fa-circle-o"></i> 货运单填写</a></li>
                    <li><a href="/waybill_select"><i class="fa fa-circle-o"></i> 货运单查询</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>配车管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/contract_add"><i class="fa fa-circle-o"></i> 运输合同填写</a></li>
                    <li><a href="/contract_select"><i class="fa fa-circle-o"></i> 运输合同查询</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>到货管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/driver_receipt_select"><i class="fa fa-circle-o"></i> 司机回执</a></li>
                    <li><a href="/customer_receipt_select"><i class="fa fa-circle-o"></i> 客户回执</a></li>
                    <li><a href="/item_select"><i class="fa fa-circle-o"></i> 新到货物</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>客户管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/complaint_add"><i class="fa fa-circle-o"></i> 客户投诉</a></li>
                    <li><a href="/complaint_manager"><i class="fa fa-circle-o"></i> 投诉处理</a></li>
                    <li><a href="/complaint_select"><i class="fa fa-circle-o"></i> 投诉历史</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>