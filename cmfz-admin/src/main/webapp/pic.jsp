<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 2018/7/5
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%--
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<script type="text/javascript">

    $(function(){
        $("#showAll").datagrid({
            width:1140,
            height:510,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/picture/showAllPicture.do",
            columns:[[
                {field:"pictureId",title:"ID",width:100},
                {field:"picturePath",title:"文件路径",width:100},
                {field:"pictureDescription",title:"描述信息",width:100},
                {field:"pictureStatus",title:"轮播图状态",width:100},
                {field:"pictureDate",title:"轮播图创建时间",width:100},
                {field:"operation",title:"操作",width:100},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="img/' + rowData.picturePath+ '.jpg" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>图片信息: ' + rowData.pictureDescription + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            pagination:true,
            pageSize:4,
            pageList:[2,4,6],
        });

        $("#cancle").linkbutton({
            onClick:function(){
                var select=$("#showAll").datagrid("getSelected");
                $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                    if (r){
                        $.ajax({
                            type:"POST",
                            url:"${pageContext.request.contextPath}/employee/cancle.do",
                            data:"id="+select.id,
                            success:function(data){
                                alert(data);
                                $("#showAll").datagrid("reload",{
                                    href:"${pageContext.request.contextPath}/employee/showAll.do"
                                });
                            }
                        });
                    }
                });
            }
        });
        $("#add").linkbutton({
            text : "新增图片",
            iconCls :"icon-add",
            onClick:function(){
                $("#dialog").dialog({
                    title: 'Add Picture',
                    width: 400,
                    height: 200,
                    collapsible : true,
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href: "${pageContext.request.contextPath}/addPic.jsp",
                    buttons : [{
                        iconCls:"icon-save",
                        text : "提交",
                        handler : function(){
                            $("#ff").form("submit",{
                                url : "${pageContext.request.contextPath}/picture/addpic.do",
                                onSubmit : function(){
                                    return $("#ff").form("validate");
                                },
                                success : function(result){
                                    $("#dg").datagrid("load",{
                                        href : "${pageContext.request.contextPath}/picture/showAllPicture.do",
                                    });
                                    $.messager.show({
                                        title:"该窗口即将关闭",
                                        msg:"对话框将在3秒后关闭",
                                        timeout:3000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                },
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $.messager.confirm("确认对话框", "您想要退出登录吗？", function(r){
                                if (r){
                                    // 退出操作，出现消息窗口 并关闭对话框
                                    $.messager.show({
                                        title:"该窗口即将关闭",
                                        msg:"对话框将在2秒后关闭",
                                        timeout:2000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                }
                            });
                        }
                    }],
                });
            }
        });

        $("#edit").linkbutton({
            onClick:function(){
                var select=$("#showAll").datagrid("getSelected");

                $("#updateTable").dialog({
                    title: 'Update Employee',
                    width: 400,
                    height: 200,
                    title : "修改用户",
                    collapsible : true,
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href: "${pageContext.request.contextPath}/updateEmp.jsp",
                    onLoad:function(){
                        $("#updateTable").form("load",select);
                    },
                    buttons:[{
                        text:'提交',
                        handler:function(){
                            $("#updateEmp").form("submit",{
                                url:"${pageContext.request.contextPath}/employee/changeEmployee.do",
                                onSubmit:function(){
                                    return $("#updateEmp").form("validate");
                                },
                                success:function(data){
                                    console.log(data);
                                    /*var result=JSON.parse(data);*/

                                    if(data=="change success"){
                                        $("#updateTable").dialog({
                                            closed:true,
                                        });
                                        $("#showAll").datagrid("reload",{
                                            href:"${pageContext.request.contextPath}/employee/showAll.do"
                                        });
                                    }
                                }

                            });
                        }
                    }]


                });
            }
        });
    });

    function qq(value, n) {
        alert(value + ":" + n)

        $("#showAll").datagrid("load",{
            value: value,
            n: n,
        });
    }

</script>
<a id="add" ></a>
<div id="dialog"></div>
<table id="showAll"></table>
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    var pagesize = 5;
    $(function() {
        $('#t1').datagrid({
            width:1000,
            height:400,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination : true,
            pageList : [ 5,10,15,20 ],
            pageSize : pagesize,
            toolbar : "#tb",
            fitColumns : true,
            singleSelect : true,
            url:"${pageContext.request.contextPath}/pic/showAllPicture.do",
            columns:[[
                {field:'pictureId',title:'标识编号',align:'center'},
                {field:'picturePath',title:'图片位置',sortable:true},
                {field:'pictureDescription',title:'描述信息',sortable:true},
                {field:'pictureStatus',title:'轮播图状态',sortable:true},
                {field:'pictureDate',title:'轮播图创建时间',align:'center'},
                /*{field:'修改',title:'操作',align:'center'},*/
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                //window.location.href = "${pageContext.request.contextPath}/upload/"+rowData.pictureName ;
                return '<table><tr>' +
                    //'<td rowspan=2 style="border:0">${pageContext.request.contextPath}/upload/'+rowData.picturePath +'</td>' +
                    '<td rowspan=2 style="border:0"><img src=${pageContext.request.contextPath}+"/upload/'+rowData.pictureId + '.jpg" style="height:150px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.pictureDescription + '</p>' +
                    '<p>Status: ' + rowData.pictureStatus + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onExpandRow : function (index,rowData) {
                console.log(rowData);
                href = "${pageContext.request.contextPath}/upload/"+rowData.pictureName;
            },
        });
        /*$('#t1').datagrid({});*/
        $("#update").linkbutton({
            iconCls : "icon-edit",
            text : "修改",
            onClick : function(){
                $("#dialog").dialog({
                    width:500,
                    height:300,
                    title:"轮播图信息修改",
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    //在对话框加载远程数据的时候触发，给表单赋值
                    onLoad : function(){
                        var select = $("#t1").datagrid("getSelected");
                        console.log(select);
                        $("#ff").form("load",select);
                    },
                    href:"${pageContext.request.contextPath}/form.jsp",
                    buttons : [{
                        iconCls:"icon-table_save",
                        text : "提交",
                        handler : function(){
                            $("#ff").form("submit",{
                                url : "${pageContext.request.contextPath}/pic/update.do",
                                onSubmit : function(){
                                    return $("#ff").form("validate");
                                },
                                success : function(result){
                                    console.log(result);
                                    alert(result);
                                    //刷新页面
                                    $("#t1").datagrid("load",{
                                        href : "${pageContext.request.contextPath}pic/showAllPicture.do",
                                    });
                                    $("#dialog").dialog("close");
                                },
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $.messager.confirm("确认对话框", "您想要取消修改吗？", function(r){
                                if (r){
                                    // 退出操作，出现消息窗口 并关闭对话框
                                    $.messager.show({
                                        title:"该窗口即将关闭",
                                        msg:"对话框将在5秒后关闭",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                }
                            });
                        }
                    }],
                });
            }
        });
        $("#delete").linkbutton({
            iconCls : "icon-cancel",
            text : "删除",
            onClick : function(){
                var select = $("#t1").datagrid("getSelected");
                console.log(select);
                $("#ff").form("load",select);
                // 关闭对话框窗口
                $.messager.confirm("确认对话框", "您确定要删除吗？", function(r){
                    if (r){
                        window.location.href = "${pageContext.request.contextPath}/pic/removepicture.do?pictureId="+select.pictureId;
                        $("#t1").datagrid("load",{
                            href : "${pageContext.request.contextPath}/pic/showAllPicture.do",
                        });
                    }
                });
            }
        });
        $("#add").linkbutton({
            iconCls : "icon-add",
            text : "新增轮播图",
            onClick : function(){
                $("#dialog").dialog({
                    width:500,
                    height:300,
                    title:"新增轮播图",
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href:"${pageContext.request.contextPath}/form.jsp",
                    buttons : [{
                        iconCls:"icon-table_save",
                        text : "提交",
                        handler : function(){
                            $("#ff").form("submit",{
                                url : "${pageContext.request.contextPath}/pic/upload.do",
                                onSubmit : function(){
                                    return $("#ff").form("validate");
                                },
                                success : function(result){
                                    console.log(result);
                                    if(result == "successful"){
                                        $.messager.show({
                                            title:"该窗口即将关闭",
                                            msg:"文件上传成功",
                                            timeout:5000,
                                            showType:"slider",
                                        });
                                        $('#t1').datagrid("load",{
                                            href : "${pageContext.request.contextPath}/pic/showAllPicture.do",
                                        });
                                        $("#dialog").dialog("close");
                                    }
                                },
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $.messager.confirm("确认对话框", "您确定要退出添加吗？", function(r){
                                if (r){
                                    // 退出操作，出现消息窗口 并关闭对话框
                                    $.messager.show({
                                        title:"该窗口即将关闭",
                                        msg:"对话框将在5秒后关闭",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                }
                            });
                        }
                    }],
                });
            }
        });

    });
</script>

<table id="t1"></table>
<div id="tb">
    <a id="update"></a>
    <a id="add" ></a>
    <a id="delete"></a>
</div>
<div id="dialog"></div>

