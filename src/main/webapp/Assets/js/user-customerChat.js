$(function () {
    $.ajax({
        url: "../../FetchCustomerChats",
        method: "POST",
        success: function (data, textStatus, jqXHR) {
//            console.log(data);
            if (data.responseCode == 1) {
                for (var i in data.tcsEmailMappedCustomerData) {
                    //                        data.tcsEmailMappedCustomerData[i].tcsEmailContent = $.parseHTML(data.tcsEmailMappedCustomerData[i].tcsEmailContent);
                    //                        data.tcsEmailMappedCustomerData[i].tcsEmailContent=data.tcsEmailMappedCustomerData[i].tcsEmailContent[0].data;
                    data.tcsEmailMappedCustomerData[i].tcsEmailContent = data.tcsEmailMappedCustomerData[i].tcsEmailContent.replace("ú", "<br>");
                    console.log(data.tcsEmailMappedCustomerData[i].tcsEmailContent);
                    $(".card-email-thread").append(templatetohtml("addProject", data.tcsEmailMappedCustomerData[i]));

                }
            } else {
                errorElsePart();
            }
        }, error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);

        }
    });

    $("#saveMail").submit(function () {
//        $(".panel-sign-in").addClass("hidden");
        $(".panel-sign-in-loader").removeClass("hidden");
        var $form = $(this);
        $.ajax({
            url: "../../SaveMailActivity",
            type: 'POST',
            data: $form.serialize(),
            success: function (data) {
                if (data.responseCode == 1) {
                    $(".card-email-thread").empty();
                    for (var i in data.tcsEmailMappedCustomerData) {
                        //                        data.tcsEmailMappedCustomerData[i].tcsEmailContent = $.parseHTML(data.tcsEmailMappedCustomerData[i].tcsEmailContent);
                        //                        data.tcsEmailMappedCustomerData[i].tcsEmailContent=data.tcsEmailMappedCustomerData[i].tcsEmailContent[0].data;
                        data.tcsEmailMappedCustomerData[i].tcsEmailContent = data.tcsEmailMappedCustomerData[i].tcsEmailContent.replace("ú", "<br>");
                        console.log(data.tcsEmailMappedCustomerData[i].tcsEmailContent);
                        $(".card-email-thread").append(templatetohtml("addProject", data.tcsEmailMappedCustomerData[i]));

                    }
                } else {
                    errorElsePart();
                }
            }
        });
        return false;
    });
});