<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="http://how2j.cn/study/jquery.min.js"></script>

<script>
    $(function(){
        $("#b1").click(function(){
            $("#d").hide();
        });
        $("#b2").click(function(){
            $("#d").show();
        });
    });

</script>

<button id="b1">隐藏div</button>

<button id="b2">显示div</button>

<br>
<br>

<div id="d">

    这是一个div

</div>