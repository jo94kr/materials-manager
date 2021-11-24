<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<body>
    <input type="button" id="test">
    <input type="button" id="test2">
    <div id="checkboxArea">
    </div>
    <div id="stuffListArea">
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

    let click = document.querySelector("#test2");
    click.onclick = function () {
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
                    drawTableBody(data, "#stuffListArea");
                })
                .catch((error) => {
                    alert(error);
                });
        }
    }

</script>