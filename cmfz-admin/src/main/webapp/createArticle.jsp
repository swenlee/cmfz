<%--
  Created by IntelliJ IDEA.
  User: wendy
  Date: 2018/7/8
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <script type="text/javascript">
        $(function(){
            $("#gurus").combobox({
                url : "${pageContext.request.contextPath}/guru/gurus.do",
                valueField : "guruId",
                textField : "guruName",
                onSelect : function(rec) {
                    console.log(guruId.guruName);
                }
            });

            $("#addA").linkbutton({
                onClick:function(){
                    var temp=editor.txt.html();
                    $("#introduction").val(temp);
                    $('#addArticle').form("submit",{
                        url:"${pageContext.request.contextPath}/article/createArticle.do",
                        onSubmit:function(){
                            return $("#addArticle").form("validate");
                        },
                        success:function(data){
                            alert(data);
                            var temp=JSON.parse(data);

                            if(temp=="添加成功"){
                                $.messager.show({
                                    title:'提示消息',
                                    msg:temp+'消息将在5秒后关闭。',
                                    timeout:5000,
                                    showType:'slide'
                                });
                               /* windows.location.href="${pageContext.request.contextPath}/articleList.jsp";*/
                            }else{
                                $.messager.alert("信息",temp);
                            }

                            /*$("#showAllGuru").datagrid("reload",{
                                href:"/guru/showAllGuru"
                            });*/
                        },
                    });
                }
            });

            $("#cancleA").linkbutton({
                iconCls:"icon-bullet_cross",
                onClick:function(){
                    $('#addArticle').form("reset");
                }
            });
        });

        function test() {
            alert(editor.txt.html());
        }
    </script>

<form id="addArticle" method="post" enctype="multipart/form-data" style="width: 800px;height: 500px;margin-left: 20px">
    <table align="center">
        <input  type="hidden"  name="mainPic" />
        <input  type="hidden"  name="introduction" id="introduction"/>
        <tr>
            <td>文章标题:</td>
            <td><input class="easyui-textbox" name="articleTitle"/></td>
        </tr>
        <tr>
            <td>文章作者:</td>
            <%--<td>
                <select  id="aName"  name="guruId" >
                    <option value="暂无">暂无</option>
                </select>
            </td>--%>
            <td><input id="gurus" name="guruId"/></td>
        </tr>
        <tr>
            <td>文章状态:</td>
            <td><input  class="easyui-switchbutton"  name="articleStatus" data-options="onText:'上架',offText:'下架'" /></td>
        </tr>
        <tr>
            <td colspan="2">文章内容:</td>
        </tr>
        <tr>
            <td colspan="2">
                <div id="editor" style="width: 800px;height: 200px" >
                    <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
                </div>
            </td>
        </tr>
    </table>

</form>
<button id="addA">创建文章</button>
<button id="cancleA">重置文章</button>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/addContent.do';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create()
</script>

