<%-- 
    Document   : index
    Created on : Jun 11, 2018, 5:42:05 PM
    Author     : bastianjoe
--%>

<%@include file="../inc/header.jsp" %>
<!--<h1> Hellow Admin</h1>-->

<style>
    .card {
        position: relative;
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        -webkit-flex-direction: column;
        -ms-flex-direction: column;
        flex-direction: column;
        background-color: #fff;
        border: 1px solid rgba(0, 0, 0, 0.125);
        border-radius: 0.25rem;
        padding: 10px;
    }
    @media (min-width: 576px) {
        .card-columns {
            -webkit-column-count: 3;
            -moz-column-count: 3;
            column-count: 3;
            -webkit-column-gap: 1.25rem;
            -moz-column-gap: 1.25rem;
            column-gap: 1.25rem;
        }
        .card-columns .card {
            display: inline-block;
            width: 100%;
            margin-bottom: 0.75rem;
        }
    }
    .defaultImg {
        height: 67px;
    }
    .defaultName {
        padding: 17px;
    }
</style>
<div class="container">
    <div class="card-columns">
        <!--    <div class="card">
                <img alt="Card image cap" class="card-img-top img-fluid" src="https://www.fillmurray.com/420/200">
                <div class="card-block">
                    <h4 class="card-title">Boating is the new canoeing</h4>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
            </div>-->
    </div>
</div>  

<!--<script src="../../Assets/js/user-index.js" type="text/javascript"></script>-->
<script id="tmpl-addProject" type="x-tmpl-mustache">

    <div class='col l3 card main-card ' data-toggle="tooltip" data-id={{tcsEmailUserId}} data-name={{tcsEmailUserName}}>
    <div class='card-content projectCardContent' >
    <div class="col-sm-4">
    <img src="../../Assets/image/default-profile.png" alt="" class="img-responsive img-thumbnail defaultImg"/>
    </div>
    <div class="col-sm-8 defaultName">
    <div>{{tcsEmailUserName}}</div>
    <!--<div>Email: {{tcsEmailPrimaryEmail}}</div>-->

    </div>
    </div>
    <div class="card-action">
    </div>
    </div>
</script>



<script>
    $(function () {
        $.ajax({
            url: "../../FetchAllUser",
            method: "POST",
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                if (data.responseCode == 1) {
                    for (var i in data.tcsEmailMappedUserData) {
                        $(".card-columns").append(templatetohtml("addProject", data.tcsEmailMappedUserData[i]));

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
                url: "../../RedirectToCustomerPage",
                method: "POST",
                data: {
                    emailUserId: $(this).attr("data-id")
//                emailCustomerName: $(this).attr("data-name")
                }, success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    if (data.responseCode == 1) {
                        window.location.href = "mappedCustomer.jsp";
                    }

                }, error: function (jqXHR, textStatus, errorThrown) {
                    console.log(errorThrown);

                }
            });
        });
    });

</script>
