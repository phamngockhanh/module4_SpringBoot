function display() {
    let content = "";
    $.ajax({
        url: "http://localhost:8080/api/blogs",
        method: "GET",
        dataTyoe: "JSON",
        success: function (response) {
            console.log(response);
            for(let i = 0;i<response.length;i++){
                content+=`
                <tr>
                    <th scope="row">${i+1}</th>
                    <td>${response[i].name}</td>
                    <td>${response[i].content}</td>
                    <td>${response[i].category.name}</td>
                    <td>${response[i].writer.name}</td>
                    <td><button type="button" class="btn btn-info">Cập nhật</button></td>
                    <td><button type="button" class="btn btn-warning">Xóa</button></td>
                </tr>`
            }
                $("#content").html(content);

        },
        error: function (error) {
            console.log(error);
        }
    })
}

function displayCategory() {
    let category = "";
    $.ajax({
        url: "http://localhost:8080/api/categories",
        method: "GET",
        dataType: "JSON",
        success: function (response) {
            console.log(response);
            for(let i = 0;i<response.length;i++){
                category+=`
                <option value="${response[i].id}">${response[i].name}</option>
                `
            }
                $("#category").html(category);

        },
        error: function (error) {
            console.log(error);
        }
    })
}

function displayWriter() {
    let writer = "";
    $.ajax({
        url: "http://localhost:8080/api/writers",
        method: "GET",
        dataType: "JSON",
        success: function (response) {
            console.log(response);
            for(let i = 0;i<response.length;i++){
                writer+=`
                <option value="${response[i].id}">${response[i].name}</option>
                `
            }
                $("#writer").html(writer);

        },
        error: function (error) {
            console.log(error);
        }
    })
}

function add(){
    let name= $("#name").val();
    let content1 = $("#content1").val();
    let category = $("#category").val();
    let writer = $("#writer").val();
    let blog = {
        name: name,
        content: content1,
        category: {
            id: Number(category)
        },
        writer: {
            id: Number(writer)
        }
    }
    console.log(blog);
    $.ajax({
        contentType: "application/json",
        url: "http://localhost:8080/api/blogs",
        method: "POST",
        data: JSON.stringify(blog),
        success: function (response) {
            console.log(response);
            display();
        },
        error: function (error) {
            console.log(error);
        }
    })
}

$(document).ready(function () {
    $('#showFormBtn').click(function () {
        $('#blogForm').slideToggle();
    });
});


display();
displayCategory();
displayWriter();
add();