$(function () {
    var data = $("#url-input").val();
    $("#url-search").click(function () {
        $.get(
            "urlFuzzyQuery",
            {"url": data},
            function (list) {
                $("#tb tr:not(:first)").empty();
                var json = JSON.parse(list);
                for (var i in json) {
                    $("#tb").append(
                        "<tr onmouseover=\"this.style.backgroundColor='#b0c4de'\" onmouseout=\"this.style.backgroundColor='#FFF'\"><td>" + json[i].id +
                        "</td><td>" + json[i].date +
                        "</td><td>" + json[i].url +
                        "</td><td>" + json[i].method +
                        "</td><td>" + json[i].ip +
                        "</td><td>" + json[i].param +
                        "</td><td>" + json[i].status +
                        "</td><td>" + json[i].timeConsuming +
                        "</td></tr>"
                    );
                }
            }
        );
    });
});