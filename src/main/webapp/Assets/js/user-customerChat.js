$(function() {
    $.ajax({
        url: "../../FetchCustomerChats",
        method: "POST",
        success: function(a, t, e) {
            if (1 === a.responseCode) {
                for (var s in a.tcsEmailMappedCustomerData) a.tcsEmailMappedCustomerData[s].tcsEmailContent = a.tcsEmailMappedCustomerData[s].tcsEmailContent.replace("ú", "<br>"), $(".card-email-thread").append(templatetohtml("addProject", a.tcsEmailMappedCustomerData[s]));
                for (var s in a.tcsEmailMasterEmailStatus) $("#status").append(templatetohtml("addMasterStatus", a.tcsEmailMasterEmailStatus[s]));
            } else errorElsePart();
        },
        error: function(a, t, e) {
           errorBlock();
        }
    }), $("#saveMail").submit(function() {
        if (null !== $("#status").val()) {
            $(".panel-sign-in-loader").removeClass("hidden");
            var a = $(this);
            $.ajax({
                url: "../../SaveMailActivity",
                type: "POST",
                data: a.serialize(),
                success: function(a) {
                    if (1 === a.responseCode) {
                        $(".card-email-thread").empty();
                        for (var t in a.tcsEmailMappedCustomerData) a.tcsEmailMappedCustomerData[t].tcsEmailContent = a.tcsEmailMappedCustomerData[t].tcsEmailContent.replace("ú", "<br>"), $(".card-email-thread").append(templatetohtml("addProject", a.tcsEmailMappedCustomerData[t]));
                        $("#cc").val(""), $("#subject").val(""), $("#date").val(""), $("#status").val(0), $("#content").val(""), DataSaved()
                    } else 2 === a.responseCode ? nullValues() : errorBlock();
                }
            });
        } else $.notify("Please select Status", "warn");
        return !1;
    });
});