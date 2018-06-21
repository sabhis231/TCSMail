var SVGLoader = '<svg version="1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="16px" height="16px" viewBox="0 0 16 16"> <style type="text/css">.qp-circular-loader{width:16px;height:16px;-webkit-animation-name:rotate;-webkit-animation-duration:1.568s;-webkit-animation-iteration-count:infinite;-webkit-animation-timing-function:linear}.qp-circular-loader-path{stroke-dasharray:32.4;stroke-dashoffset:32.4;-webkit-animation-name:fillunfill,rot,colors;-webkit-animation-duration:1333ms,5332ms,5332ms;-webkit-animation-iteration-count:infinite,infinite,infinite;-webkit-animation-timing-function:cubic-bezier(.4,0,.2,1),steps(4),linear;-webkit-animation-play-state:running,running,running;-webkit-animation-fill-mode:forwards}.qp-circular-loader,.qp-circular-loader *{-webkit-transform-origin:50% 50%}@-webkit-keyframes rotate{from{-webkit-transform:rotate(0)}to{-webkit-transform:rotate(360deg)}}@-webkit-keyframes fillunfill{from{stroke-dashoffset:32.3}50%{stroke-dashoffset:0}to{stroke-dashoffset:-31.9}}@-webkit-keyframes rot{from{-webkit-transform:rotate(0)}to{-webkit-transform:rotate(-360deg)}}@-webkit-keyframes colors{from,to{stroke:#FFF}}</style> <g class="qp-circular-loader"> <path class="qp-circular-loader-path" fill="none" d="M 8,1.125 A 6.875,6.875 0 1 1 1.125,8" stroke-width="2.25" stroke-linecap="round"></path> </g> </svg>&emsp;<i>loading...</i>';
        var TmpHtml = '';
        $(function() {
        $("#login").submit(function() {
        $(".panel-sign-in").addClass("hidden");
                $(".panel-sign-in-loader").removeClass("hidden");
                var $form = $(this);
                $.ajax({
                url: "DoAuth",
                        type: 'POST',
                        data: $form.serialize(),
//                        data: {
//                        userName: "1272011@tcs.com",
//                                password: "Tcs#1234"
//
//                        },
                        success: function(data) {
                        console.log(data);
                                if (data.responseCode === 1 && data.doauth === true) {
                        $.notify("Redirecting", "success");
//                        console.log("hi");
                               window.location.href = contextPath + "/views/" + data.role + "/";
                        } else {
                        $.notify("Invalid Credentials", "error");
                                $(".panel-sign-in").removeClass("hidden");
                                $(".panel-sign-in-loader").addClass("hidden");
                        }
                        }
                });
                return false;
        });
        });
//pixie canvas background
        function BrowserDetection() {
        if (/Firefox[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
        var e = new Number(RegExp.$1);
                rint = 10;
                pulsion = 3
        } else if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)) {
        var t = new Number(RegExp.$1);
                rint = 50;
                pulsion = 16
        } else if (/Chrome[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
        var n = new Number(RegExp.$1);
                rint = 50;
                pulsion = 16
        } else if (/Opera[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
        var r = new Number(RegExp.$1);
                rint = 50;
                pulsion = 16
        } else if (/Safari[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
        var i = new Number(RegExp.$1);
                rint = 50;
                pulsion = 16
        }
        WIDTH = window.innerWidth;
                if (WIDTH < 1024) {
        numberObject = 19e3;
                numberBall = 10;
                pulsion = 2;
                rint = 10
        }
        }
function draw() {
con.clearRect(0, 0, WIDTH, HEIGHT);
        for (var e = 0; e < pxs.length; e++) {
pxs[e].fade();
        pxs[e].move();
        pxs[e].draw()
        }
}
function Circle() {
WIDTH = window.innerWidth;
        HEIGHT = window.innerHeight;
        this.s = {
        ttl: numberObject,
                xmax: speedX,
                ymax: speedY,
                rmax: radius,
                rt: pulsion,
                xdef: 960,
                ydef: 540,
                xdrift: 4,
                ydrift: 4,
                random: true,
                blink: true
        };
        this.reset = function() {
        this.x = this.s.random ? WIDTH * Math.random() : this.s.xdef;
                this.y = this.s.random ? HEIGHT * Math.random() : this.s.ydef;
                this.r = (this.s.rmax - 1) * Math.random() + 1;
                this.dx = Math.random() * this.s.xmax * (Math.random() < .5 ? - 1 : 1);
                this.dy = Math.random() * this.s.ymax * (Math.random() < .5 ? - 1 : 1);
                this.hl = this.s.ttl / rint * (this.r / this.s.rmax);
                this.rt = Math.random() * this.hl;
                this.s.rt = Math.random() + 1;
                this.stop = Math.random() * .2 + .4;
                this.s.xdrift *= Math.random() * (Math.random() < .5 ? - 1 : 1);
                this.s.ydrift *= Math.random() * (Math.random() < .5 ? - 1 : 1)
        };
        this.fade = function() {
        this.rt += this.s.rt
        };
        this.draw = function() {
        if (this.s.blink && (this.rt <= 0 || this.rt >= this.hl))
                this.s.rt = this.s.rt * - 1;
                else if (this.rt >= this.hl)
                this.reset();
                var e = 1 - this.rt / this.hl;
                con.beginPath();
                con.arc(this.x, this.y, this.r, 0, Math.PI * 2, true);
                con.closePath();
                var t = this.r * e;
                g = con.createRadialGradient(this.x, this.y, 0, this.x, this.y, t <= 0 ? 1 : t);
                g.addColorStop(1, colorRect + e * opacityRect + ")");
                con.fillStyle = g;
                con.fill()
        };
        this.move = function() {
        WIDTH = window.innerWidth;
                HEIGHT = window.innerHeight;
                this.x += this.rt / this.hl * this.dx;
                this.y += this.rt / this.hl * this.dy;
                if (this.x > WIDTH || this.x < 0)
                this.dx *= - 1;
                if (this.y > HEIGHT || this.y < 0)
                this.dy *= - 1
        };
        this.getX = function() {
        return this.x
        };
        this.getY = function() {
        return this.y
        }
}
var WIDTH;
        var HEIGHT;
        var canvas;
        var con;
        var g;
        var pxs = new Array;
        var numberObject = 8e3;
        var numberBall = 25;
        var pulsion = 16;
        var speedX = 5;
        var speedY = 2;
        var colorRect = "rgba(255,255,255,0.05)";
        var opacityRect = .2;
        var rint = 30;
        var radius = 100;
        $(document).ready(function() {
BrowserDetection();
        WIDTH = window.innerWidth;
        HEIGHT = window.innerHeight;
        canvas = document.getElementById("pixie");
        $(canvas).attr("width", WIDTH).attr("height", HEIGHT);
        con = canvas.getContext("2d");
        for (var e = 0; e < numberBall; e++) {
pxs[e] = new Circle;
        pxs[e].reset()
        }
setInterval(draw, rint)
})