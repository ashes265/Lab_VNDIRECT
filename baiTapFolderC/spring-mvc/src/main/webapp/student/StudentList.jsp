<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Student List</title>
    <script>
        function view(id) {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open("GET", "json/" + id, true);
            xmlHttp.onload = function () {
                if (this.status != 200) return;
                console.log(this.responseText);
                // var student = JSON.stringify(this.responseText);
                // var student = xml2json(this.responseText);
                // var student = JSON.parse(xml2json(this.responseText));
                // var a = parseXmlToJson(this.responseText);
                var a=JSON.parse(this.responseText);
                console.log(a);
                // var student = temp;
                document.getElementById('content').innerHTML = 'Name: ' + a.name
                    + '<img src="../student/avatar/' + a.id + '" >';
                var dialog = document.getElementById('viewStudent');
                dialog.show();
            }
            xmlHttp.send();
        }

        function parseXmlToJson(xml) {
            const json = {};
            for (const res of xml.matchAll(/(?:<(\w*)(?:\s[^>]*)*>)((?:(?!<\1).)*)(?:<\/\1>)|<(\w*)(?:\s*)*\/>/gm)) {
                const key = res[1] || res[3];
                const value = res[2] && parseXmlToJson(res[2]);
                json[key] = ((value && Object.keys(value).length) ? value : res[2]) || null;

            }
            return json;
        }

        function xml2json(xml) {
            try {
                var obj = {};
                if (xml.children.length > 0) {
                    for (var i = 0; i < xml.children.length; i++) {
                        var item = xml.children.item(i);
                        var nodeName = item.nodeName;

                        if (typeof (obj[nodeName]) == "undefined") {
                            obj[nodeName] = xml2json(item);
                        } else {
                            if (typeof (obj[nodeName].push) == "undefined") {
                                var old = obj[nodeName];

                                obj[nodeName] = [];
                                obj[nodeName].push(old);
                            }
                            obj[nodeName].push(xml2json(item));
                        }
                    }
                } else {
                    obj = xml.textContent;
                }
                return obj;
            } catch (e) {
                console.log(e.message);
            }
        }
    </script>


    <script>
        function showPos(event, text) {
            var el = document.getElementById('PopUp');
            var x, y;
            if (window.event) {
                x = window.event.clientX + document.documentElement.scrollLeft + document.body.scrollLeft;
                y = window.event.clientY + document.documentElement.scrollTop + document.body.scrollTop;
            } else {
                x = event.clientX + window.scrollX;
                y = event.clientY + window.scrollY;
            }
            x -= 2;
            y -= 2;
            y = y + 15
            el.style.left = x + "px";
            el.style.top = y + "px";
            el.style.display = "block";
            document.getElementById('PopUpText').innerHTML = text;
        }
    </script>
</head>
<tiles:insertDefinition name="studentTemplate">
    <tiles:putAttribute name="body">
        <h2>List of Students</h2>
        <form method="GET" action="list">
            <table border="1">
                <tr>
                    <td colspan="4"><input type="text" name="q" size="30"></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Age</td>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td><a href="javascript:view(${student.id})">${student.name}</a></td>
                    <td>${student.age}</td>
                    <td><a href="delete/${student.id}">delete</a></td>
                    <td><a href="edit/${student.id}">edit</a></td>
                </tr>
            </c:forEach>
        </table>
        <dialog id="viewStudent" style="width: 50%;border: 1px dotted black;">
            <div id="content">
            </div>
            <button id="hide">Close</button>
        </dialog>
        <script>
            (function () {
                var dialog = document.getElementById('viewStudent');
                document.getElementById('hide').onclick = function () {
                    dialog.close();
                };
            })();
        </script>
        <div id='PopUp'
             style='display: none; position: absolute; left: 100px; top: 50px; border: solid black 1px; padding: 10px; background-color: rgb(200,100,100); text-align: justify; font-size: 12px; width: 135px;'
             onmouseover="document.getElementById('PopUp').style.display = 'none' ">
            <SPAN id='PopUpText'>TEXT</SPAN>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>
</html>

