<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
</head>
<style>
    table {
        border: 1px solid #444444;
        border-collapse: collapse;
    }

    th,td {
        border: 1px solid #444444;
    }
</style>

<body>
    <input type="button" id="test">
    <input type="button" id="getStuffListBtn">
    <input type="button" id="addStuffBtn">
    <div id="checkboxArea">
    </div>
    <div id="stuffListArea">
        <table>
            <thead>
                <tr>
                    <th><input type="checkbox" name="delCheckBoxAll"></th>
                    <th>stuffCategory</th>
                    <th>stuffName</th>
                    <th>stuffCount</th>
                    <th>rentalCount</th>
                    <th>returnCount</th>
                    <th>etc</th>
                </tr>
            </thead>
            <tbody id="stuffTableArea">
            </tbody>
        </table>
    </div>
</body>

<script src="js/util.js"></script>

<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function () {
        getCategoryList();
    });

    function getCategoryList() {
        fetch("/getCategoryList")
            .then(result => result.json())
            .then(result => {
                drawCategoryCheckbox(result);
            }).catch(err => {
                console.log(err);
            });
    }

    function drawCategoryCheckbox(result) {
        let checkbox = document.getElementById("checkboxArea");

        result.forEach(element => {
            let label = document.createElement("label");
            label.innerHTML = element;

            let input = document.createElement("input");
            input.name = "categoryCheckbox";
            input.type = "checkbox";
            input.value = element;

            checkbox.appendChild(label);
            label.appendChild(input);
        });
    }

    let getStuffListBtn = document.querySelector("#getStuffListBtn");
    getStuffListBtn.onclick = function() {
        let checkedBox = document.querySelectorAll("input[name='categoryCheckbox']:checked");

        let categoryList = new Array();
        checkedBox.forEach(checked => {
            categoryList.push(checked.value);
        });

        if (categoryList.length > 0) {
            let sendData = {};
            sendData["categoryList"] = categoryList;
            
            get("/getStuffList", sendData)
                .then((data) => {
                    drawTableBody(data, "#stuffTableArea");
                })
                .catch((error) => {
                    alert(error);
                });
        }
    }

    let addStuffBtn = document.querySelector("#addStuffBtn");
    addStuffBtn.onclick = function() {
        let sendData = {};
        sendData["stuffCategory"] = "test1";
        sendData["stuffName"] = "test2";
        sendData["stuffCount"] = "test3";
        sendData["rentalCount"] = "test4";
        sendData["returnCount"] = "test5";
        sendData["etc"] = "test6";

        post("/insetStuff", sendData)
            .then((data) => {
                console.log(data);
            })
            .catch((error) => {
                alert(error);
            });
    }

    let delStuffBtn = document.querySelector("#delStuffBtn");
    delStuffBtn.onclick = function() {
        console.log();
        document.querySelectorAll("input[name='delCheckBox']");
    }


</script>