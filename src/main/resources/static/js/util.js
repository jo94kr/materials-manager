/**
 * GET 방식 호출
 * Parameters 포함, 미포함 방식으로 분기
 * 
 * @param {String} url 
 * @param {Object} params 
 * @returns 
 */
async function get(url, params) {
    let res;
    if (arguments.length == 2) {
        if (typeof params == "object") {
            const query = Object.keys(params)
                .map(k => encodeURIComponent(k) + "=" + encodeURIComponent(params[k]))
                .join("&");
            res = await fetch(url + "?" + query);
        } else {
            throw Error("Params Type Error. Params Type must be Object: params=" + typeof (params))
        }
    }
    else {
        res = await fetch(url);
    }
    const data = await res.json();
    if (res.ok) {
        return data
    } else {
        throw Error(data);
    }
}

/**
 * POST 방식 호출
 * 
 * @param {String} host 
 * @param {String} path 
 * @param {String} body 
 * @param {Array} headers 
 * @returns 
 */
async function post(url, body, headers = {}) {
    console.log(body);
    console.log(JSON.stringify(body));
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            ...headers,
        },
        body: JSON.stringify(body),
    };
    const res = await fetch(url, options);
    const data = await res.json();
    if (res.ok) {
        return data;
    } else {
        throw Error(data);
    }
}

/**
 * 지정한 타겟에 테이블 바디 렌더링
 * 
 * @param {Object} data 
 * @param {String} target 
 * @param {Array} excludeCols 
 */
function drawTableBody(data, target, excludeCols) {
    let tableArea = document.querySelector(target);

    console.log(data);
    data.forEach(element => {
        if (arguments.length == 3 && typeof excludeCols == "Array" && excludeCols.length > 0) {
            excludeCols.forEach(deleteCol => {
                delete element[deleteCol];
            });
        }

        let tr = tableArea.insertRow();
        for (var key in element) {
            let td = tr.insertCell();
            td.innerText = element[key]
        }
    });
}