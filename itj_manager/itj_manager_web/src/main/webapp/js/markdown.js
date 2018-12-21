function createMarkdownEditor(editor,language,saveFunction,account) {
    editormd(editor, {
    	lang:language,
        width: "90%",
        height: 740,
        path: '/ITJ/editor/lib/',
        theme: "dark",
        previewTheme: "dark",
        editorTheme: "pastel-on-dark",
        codeFold: true,
        searchReplace: true,
        // htmlDecode: true,
        // htmlDecode: "style,script,iframe|on*",
        emoji: true,
        taskList: true,
        tocm: true,
        tex: true,
        flowChart: true,
        sequenceDiagram: true,
        dialogMaskOpacity: 0.4,
        dialogMaskBgColor: "#000",
        imageUpload: true,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL: "/ITJ/ac.itj/addimg.itj?account="+account,
        toolbarIcons: ["undo", "redo", "|","bold", "del", "italic", "quote", "ucwords", "uppercase", "lowercase", "|",
            "h1", "h2", "h3", "h4", "h5", "h6", "|","list-ul", "list-ol", "hr", "|",
            "link", "reference-link", "image", "code", "preformatted-text", "code-block", "table", "datetime",
            "emoji", "html-entities", "pagebreak", "|", "goto-line", "watch", "preview", "fullscreen", "clear", "search", "|",
            "help", "save","back"
        ],
        toolbarIconsClass: {
            save: "fa-save"
        },
		toolbarCustomIcons :{
			back:"<button id='back' onclick='back()'></button>"
		},
		toolbarHandlers:{
			save:saveFunction
		},
		katexURL :{
			css:"/ITJ/css/katex.css"
		},
        onload:function () {
            this.fullscreen();
        }
    });
}
$(function() {
    $("body").css("background-size", window.innerWidth + "px " + window.innerHeight + "px");
});