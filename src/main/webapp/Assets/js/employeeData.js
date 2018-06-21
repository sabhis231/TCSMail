/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('.dropdown-trigger').dropdown();
var tcsIOUDetails = [];
var availableTags = [];
$(function () {
    $.ajax({
        url: "FetchAllTcsIOU",
        success: function (data) {
            console.log(data);
            if (data.responseCode == 1) {
                tcsIOUDetails = data.tcsIOUDetails;
                $("#dropdown1").html("<h5>Select Iou</h5>");
                for (var i in tcsIOUDetails) {
                    availableTags.push(tcsIOUDetails[i].tcsIouName);

                    $("#dropdown1").append(templatetohtml("addIOUList", tcsIOUDetails[i]));

//                    $("#masterIou").append("<p class='clickIou' data='" + tcsIOUDetails[i].tcsIouId + "'>" + tcsIOUDetails[i].tcsIouName + "<p>");
                }
                $("#inputHidden").val(1);
            } else {
                errorElsePart();
            }
            $("#tags").autocomplete({
                source: availableTags
            });
        }, error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
            errorBlock();
        }
    });
    $("body").on("click", ".clickIou", function () {
        var selectedIou = $(this).attr("data");
        console.log(selectedIou);
        $.ajax({
            url: "RedirectToEmployee",
            data: {
                masterIou: selectedIou
            },
            success: function (data) {
                console.log(data);
                if (data.responseCode == 1) {
                    window.location.href = "admin/employee"
                } else {
                    errorElsePart();
                }
            }
            , error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
                errorBlock();
            }
        });
    });
//    $("body").on("click", ".selectIou", function () {
//        console.log((this));
//    });

    $("body").on("click", "#searchProject", function () {
        console.log($("#tags").val());
        $.ajax({
            url: "RedirectToProject",
            method: "GET",
            data: {
                iouName: $("#tags").val(),
                type: 2
            }, success: function (data, textStatus, jqXHR) {
                console.log(data);
                if (data.responseCode == 1) {
                    window.location.href = "admin/project"
                } else {
                    errorBlock();
                }
            }, error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
                errorBlock();

            }
        });
    });



});
var selectIou = function (selectIou, selectedIouName) {
    console.log(selectedIouName);
    $.ajax({
        url: "RedirectToProject",
        method: "GET",
        data: {
            iou: selectIou,
            iouName: selectedIouName,
            type: 1
        }, success: function (data, textStatus, jqXHR) {
            console.log(data);
            if (data.responseCode == 1) {
                window.location.href = "admin/project"
            } else {
                errorBlock();
            }
        }, error: function (jqXHR, textStatus, errorThrown) {
//            console.log(errorThrown);
            errorBlock();

        }
    });
};
    