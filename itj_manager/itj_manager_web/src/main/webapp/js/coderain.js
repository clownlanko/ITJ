var c = document.getElementById("coderain");
var ctx = c.getContext("2d");
/** 这里控制显示的宽度和高度，且涵盖所有浏览器 */
c.width = window.innerWidth
    || document.documentElement.clientWidth
    || document.body.clientWidth;
c.height = window.innerHeight
    || document.documentElement.clientHeight
    || document.body.clientHeight;

var chinese = "ITJBOLG";

var fsize = 20;
columns = c.width / fsize;

var drops=[];
for(var x=0;x<columns;x++) {
    drops[x] = 0;
}
function draw(){
    ctx.fillStyle="rgba(0,0,0,0.09)";
    ctx.fillRect(0,0, c.width, c.height);
    ctx.fillStyle="#0f0";
    ctx.font = fsize + "px arial";// arial is font.
    var r,g,b,a;
    r=g=b=a=0;
    for(var i=0;i<drops.length;i++){
        r=Math.floor(Math.random()*256);
        g=Math.floor(Math.random()*256);
        b=Math.floor(Math.random()*256);
        a=Math.random();
        ctx.fillStyle="rgba("+r+","+g+","+b+","+a+")";
        var text = chinese[Math.floor(Math.random()*chinese.length)];
        ctx.fillText(text,i*fsize,drops[i]*fsize);
        drops[i]++;
        if(drops[i]*fsize > c.height && Math.random() > 0.9){
            drops[i] = 0;
        }
    }
}
setInterval(draw,50);

