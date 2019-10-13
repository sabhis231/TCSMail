<%-- Document : index Created on : Jun 11, 2018, 5:42:30 PM Author : bastianjoe --%>
<%@include file="../inc/header.jsp" %>
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
        padding: 10px
    }
    @media (min-width: 576px) {
        .card-columns {
            -webkit-column-count: 3;
            -moz-column-count: 3;
            column-count: 3;
            -webkit-column-gap: 1.25rem;
            -moz-column-gap: 1.25rem;
            column-gap: 1.25rem
        }
        .card-columns .card {
            display: inline-block;
            width: 100%;
            margin-bottom: 0.75rem
        }
    }
    .defaultImg {
        height: 67px
    }
    .defaultName {
        padding: 17px
    }                    
</style>
<div class="container">
    <div class="card-columns"></div>
</div>
<script src="../../Assets/js/user-index.js" type="text/javascript"></script>
<script id="tmpl-addProject" type="x-tmpl-mustache">

    <div class='col l3 card main-card ' data-toggle="tooltip" data-id={{tcsEmailCustomerId}} data-name={{tcsEmailCustomerFullName}}>
    <div class='card-content projectCardContent' >
    <div class="col-sm-4">
    <img src="../../Assets/image/default-profile.png" alt="" class="img-responsive img-thumbnail defaultImg"/>
    </div>
    <div class="col-sm-8 defaultName">
    <div>{{tcsEmailCustomerName}}</div>
    </div>
    </div>
    <div class="card-action">
    </div>
    </div>
</script>
