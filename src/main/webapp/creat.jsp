<%-- 
    Document   : main
    Created on : Mar 26, 2019, 7:04:40 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/vue"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
        <link href="https://code.jquery.com/ui/1.12.1/themes/ui-lightness/jquery-ui.css" rel="stylesheet" type="text/css" />
    </head> 
    <script>
//        $(document).ready(function () {
//            let vue = new Vue({
//                "el": "#app",
//                "data": {
//                    items: []
//                }
//            });
//
//            $.ajax("webapi/items", {
//                success: function (d) {
//                    vue.items = d;
//                }
//
//            });
//        });
    </script>
    <body>
        <div id="app">
            Product Name : <input type="text" v-model="item.product"><br/>
            Unit Price: <input type="text" v-model="item.unitprice"><br/>
            Amount: <input type="text" v-model="item.amount"><br/>
            <button onclick="save();">Save</button>
        </div>
        
        <script>
            let v=null;
            v=new Vue({
               el:"#app",
               data:{
                   item:{
                       product:"",
                       unitprice:"",
                       amount:""
                   }
               }
            });
            function save(){
                $.ajax("webapi/item",{
                    type:"POST",
                    contentType:"application/json",
                    data:JSON.stringify(v.item),
                    success:function(){
                        window.location.href="list.jsp";
                    }
                })
            }
        </script>
    </body>
</html>
