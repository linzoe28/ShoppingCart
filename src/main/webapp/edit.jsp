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
        $(document).ready(function () {
            let v = null;
            $.ajax("webapi/item/<%=request.getParameter("item")%>", {
                success: function (r) {
                    v = new Vue({
                        "el": "#app",
                        "data": {
                            item: r
                        },
                        "methods":{
                            update:function(){
                                
                            }
                        }
                    });
                }
            });
        });
    </script>
    <body>
        <div id="app">
            Product Name : {{item.product}}<br/>
            Unit Price:{{item.unitprice}}<br/>
            Amount: <input type="text" v-model="item.amount"><br/>
            <button v-on:click="">Update</button>
        </div>
    </body>
</html>
