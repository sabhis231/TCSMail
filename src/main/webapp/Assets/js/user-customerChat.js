$(function () {


    $.ajax({
        url: "../../FetchCustomerChats",
        method: "POST",
        success: function (data, textStatus, jqXHR) {
//            console.log(data);
            if (data.responseCode == 1) {
                for (var i in data.tcsEmailMappedCustomerData) {
                    data.tcsEmailMappedCustomerData[i].tcsEmailContent = data.tcsEmailMappedCustomerData[i].tcsEmailContent.replace("ú", "<br>");
                    $(".card-email-thread").append(templatetohtml("addProject", data.tcsEmailMappedCustomerData[i]));

                }
                for (var i in data.tcsEmailMasterEmailStatus) {
                    $("#status").append(templatetohtml("addMasterStatus", data.tcsEmailMasterEmailStatus[i]));

                }
            } else {
                errorElsePart();
            }
        }, error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);

        }
    });

    $("#saveMail").submit(function () {
        if ($("#status").val() != null) {
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
                            data.tcsEmailMappedCustomerData[i].tcsEmailContent = data.tcsEmailMappedCustomerData[i].tcsEmailContent.replace("ú", "<br>");
                            $(".card-email-thread").append(templatetohtml("addProject", data.tcsEmailMappedCustomerData[i]));

                        }
                        $("#cc").val("");
                        $("#subject").val("");
                        $("#date").val("");
                        $("#status").val(0);
                        $("#content").val("");
                        DataSaved();
                    } else if (data.responseCode == 2) {
                        nullValues();
                    } else {
                        errorBlock();
                    }
                }
            });
        } else {



            $.notify("Please select Status", "warn");
        }
        return false;
    });
});