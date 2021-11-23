<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
    <input type="button" id="test">
    <input type="button" id="test2">

</body>

<script src="js/jquery.min.js"></script>
<script type="text/javascript">
    $('#test').click(function() {
        console.log('test');

        $.ajax({
            type:'GET',
            url:'/getCategoryList',
            success: function(data){
                console.log(data);
            },
            error: function(e){
                console.log(e);
            }

        });
    });

    $('#test2').click(function() {
        console.log('test2');
        var sendData = {};
        sendData['categoryList'] = ['test', 'test2'];

        $.ajax({
            type:'GET',
            data: sendData,
            url:'/getStuffList',
            success: function(data){
                console.log(data);
            },
            error: function(e){
                console.log(e);
            }

        });
    });
</script>

