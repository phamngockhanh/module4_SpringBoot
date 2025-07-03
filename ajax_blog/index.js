$(document).ready(function () {
  let page = 0;
  display(page);
  displayCategory();
  displayWriter();
  $("#btn-update").hide();
  $("#btn-more").click(displayMore);
  $("#btn-add").click(function (event) {
    event.preventDefault();
    add();
    $("#blogForm").slideToggle();
  });
  $("#btn-search").click(function (event) {
    event.preventDefault();
    page = 0;
    $("#content").html("");
    display(page);
  });
  function add() {
    let name = $("#name").val();
    let content1 = $("#content1").val();
    let category = $("#category").val();
    let writer = $("#writer").val();
    let blog = {
      name: name,
      content: content1,
      category: {
        id: Number(category),
      },
      writer: {
        id: Number(writer),
      },
    };
    console.log(blog);
    $.ajax({
      contentType: "application/json",
      url: "http://localhost:8080/api/blogs",
      method: "POST",
      data: JSON.stringify(blog),
      success: function (response) {
        console.log(response);
        page = 0;
        $("#content").html("");
        display(page);
        $("#name").val("");
        $("#content1").val("");
        $("#category").val($("#category option:first").val());
        $("#writer").val($("#writer option:first").val());
      },
      error: function (error) {
        console.log(error);
      },
    });
  }
  function displayMore() {
    page++;
    display(page);
  }

  function display() {
    let content = "";
    let title = $("#search").val();
    $.ajax({
      url: `http://localhost:8080/api/blogs?page=${page}&title=${title}`,
      method: "GET",
      dataType: "JSON",
      success: function (data, textStatus, res) {
        console.log(data);
        for (let i = 0; i < data.content.length; i++) {
          content += `
                <tr>
                    <th scope="row">${i + 1 + page * data.size}</th>
                    <td scope="row">${data.content[i].name}</td>
                    <td scope="row">${data.content[i].content}</td>
                    <td scope="row">${data.content[i].category.name}</td>
                    <td scope="row">${data.content[i].writer.name}</td>
                    <td><button type="button" class="btn btn-info btn-update" data-id="${
                      data.content[i].id
                    }">Cập nhật</button></td>
                    <td><button type="button" class="btn btn-warning" data-id="${
                      data.content[i].id
                    }">Xóa</button></td>
                </tr>`;
        }
        $("#content").append(content);
      },
      error: function (error) {
        console.log("-----------lỗi---------");
        console.log(error);
      },
    });
  }

  function displayCategory() {
    let category = "";
    $.ajax({
      url: "http://localhost:8080/api/categories",
      method: "GET",
      dataType: "JSON",
      success: function (response) {
        console.log(response);
        for (let i = 0; i < response.length; i++) {
          category += `
                <option value="${response[i].id}">${response[i].name}</option>
                `;
        }
        $("#category").html(category);
      },
      error: function (error) {
        console.log(error);
      },
    });
  }

  function displayWriter() {
    let writer = "";
    $.ajax({
      url: "http://localhost:8080/api/writers",
      method: "GET",
      dataType: "JSON",
      success: function (response) {
        console.log(response);
        for (let i = 0; i < response.length; i++) {
          writer += `
                <option value="${response[i].id}">${response[i].name}</option>
                `;
        }
        $("#writer").html(writer);
      },
      error: function (error) {
        console.log(error);
      },
    });
  }
  $("#showFormBtn").click(function () {
    $("#blogForm").slideToggle();
  });
  $("#content").on("click", ".btn-warning", function () {
    let id = $(this).data("id");
    console.log(id);
    $.ajax({
      url: `http://localhost:8080/api/blogs/${id}`,
      method: "DELETE",
      dataType: "JSON",
      success: function (response) {
        page = 0;
        $("#content").html("");
        display(page);
      },
      error: function (error) {
        console.log(error);
      },
    });
  });

  let currentBlogId = null;
  $("#content").on("click", ".btn-update", function () {
    let blogId = $(this).data("id");
    console.log("Clicked blogId:", blogId);
    currentBlogId = blogId;
    $.ajax({
      url: `http://localhost:8080/api/blogs/${blogId}`,
      method: "GET",
      dataType: "JSON",
      success: function (response) {
        console.log(response);
        $("#name").val(response.name);
        $("#content1").val(response.content);
        $("#category").val(response.category.id);
        $("#writer").val(response.writer.id);
        $("#btn-add").hide();
        $("#btn-update").show();
        $("#blogForm").slideDown();
      },
      error: function (err) {
        console.error("Lỗi lấy blog:", err);
      },
    });
  });
  $("#btn-update").click(function (event) {
    event.preventDefault();
    console.log("currentBlogId:", currentBlogId);

    let name = $("#name").val();
    let content1 = $("#content1").val();
    let category = $("#category").val();
    let writer = $("#writer").val();
    console.log("Form data:", name, content1, category, writer);
    let blog = {
      name: name,
      content: content1,
      category: {
        id: Number(category),
      },
      writer: {
        id: Number(writer),
      },
    };
    console.log("Blog object to update:", blog);
    $.ajax({
      contentType: "application/json",
      url: `http://localhost:8080/api/blogs/${currentBlogId}`,
      method: "PUT",
      data: JSON.stringify(blog),
      success: function (response) {
        console.log(response);
        page = 0;
        $("#content").html("");
        $("#blogForm").slideUp();
        $("#btn-add").show();
        $("#btn-update").hide();
        $("#name").val("");
        $("#content1").val("");
        $("#category").val($("#category option:first").val());
        $("#writer").val($("#writer option:first").val());
        display(page);
      },
      error: function (error) {
        console.log(error);
      },
    });
  });
});
