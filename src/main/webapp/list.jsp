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
            let vue = new Vue({
                "el": "#app",
                "data": {
                    items: []
                },
                "methods": {
                    edit: function (item) {
                        window.location.href = "edit.jsp?item=" + item.product;
                    },
                    remove: function (item) {
                       $.ajax("webapi/item/"+item.product,{
                          type:"DELETE",
                          success:function(){
                               window.location.href = "list.jsp";
                          }
                       });
                    }
                }
            });

            $.ajax("webapi/items", {
                success: function (d) {
                    vue.items = d;
                }

            });
        });
    </script>
    <body>
        <button onclick="add();">ADD</button>
        <script>
            function add(){
                window.location.href="creat.jsp";
            }
        </script>
        <table border="1" style="width: 90%" id="app">
            <thead>
                <tr>
                    <th>product name</th>
                    <th>unit price</th>
                    <th>amount</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in items">
                    <td>{{item.product}}</td>
                    <td>{{item.unitprice}}</td>
                    <td>{{item.amount}}</td>
                    <td><button v-on:click="edit(item);">EDIT</button>
                        <button v-on:click="remove(item);">DELETE</button></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
