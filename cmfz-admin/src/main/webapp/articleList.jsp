
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $('#article_t1').datagrid({
            width:1100,
            height:400,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination : true,
            pageList : [ 5,10,15,20 ],
            pageSize : 5,
            toolbar : "#article_tb",
            fitColumns : true,
            singleSelect : true,
            url:"${pageContext.request.contextPath}/article/getallarticles.do",
            columns:[[
                {field:'articleId',title:'文章编号',align:'center'},
                {field:'articleTitle',title:'文章标题',sortable:true},
                {field:'articleStatus',title:'状态',sortable:true},
                {field:'date',title:'创建时间',sortable:true},
                {field:'guruName',title:'文章作者',sortable:true},
                /*{ field: 'field', title: '按钮', width: 100, align: 'center', formatter: aaa }*/
            ]],
        });
    })
</script>

<table id="article_t1"></table>
<div id="article_tb">
</div>