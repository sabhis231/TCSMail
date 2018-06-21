$(function () {
    $.ajax({
        url: "../../FetchUserMappedCustomer",
        method: "POST",
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if (data.responseCode == 1) {
                for (var i in data.tcsEmailMappedCustomerData) {
//                    data.tcsEmailMappedCustomerData[i].fulName=data.tcsEmailMappedCustomerData[i].tcsEmailCustomerName;
//                    console.log(data.tcsEmailMappedCustomerData[i]);
                    $(".card-columns").append(templatetohtml("addProject", data.tcsEmailMappedCustomerData[i]));

                }
            } else {
                errorElsePart();
            }
        }, error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
        }

    });
    $("body").on("click", ".main-card", function () {
        console.log($(this).attr("data-id"));
        $.ajax({
            url: "../../RedirectToChatPage",
            method: "POST",
            data: {
                emailCustomerId: $(this).attr("data-id"),
                emailCustomerName: $(this).attr("data-name")
            }, success: function (data, textStatus, jqXHR) {
                console.log(data);
                if (data.responseCode == 1) {
                    window.location.href = "customerChat.jsp";
                }

            }, error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);

            }
        });
    });


});