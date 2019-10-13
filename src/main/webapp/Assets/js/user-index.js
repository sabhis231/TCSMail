$(function() {
    $.ajax({
        url: "../../FetchUserMappedCustomer",
        method: "POST",
        success: function(e, t, o) {
            if (console.log(e), 1 === e.responseCode)
                for (var a in e.tcsEmailMappedCustomerData) $(".card-columns").append(templatetohtml("addProject", e.tcsEmailMappedCustomerData[a]));
            else errorElsePart();
        },
        error: function(e, t, o) {
            errorBlock();
        }
    }), $("body").on("click", ".main-card", function() {
        console.log($(this).attr("data-id")), $.ajax({
            url: "../../RedirectToChatPage",
            method: "POST",
            data: {
                emailCustomerId: $(this).attr("data-id"),
                emailCustomerName: $(this).attr("data-name")
            },
            success: function(e, t, o) {
                1 === e.responseCode && (window.location.href = "customerChat.jsp");
            },
            error: function(e, t, o) {
                errorBlock();
            }
        });
    });
});