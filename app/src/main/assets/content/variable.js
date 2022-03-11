//var folder = "content/img/";
var folder = "file:///data/data/wali.panduan.haji.umroh.audio/files/"
if(navigator.userAgent.indexOf("Firefox") != -1 ){
folder = "img/";
}

function loadImage(param)
{
document.write('<img src="' + folder + param+'"' + '/>');
}