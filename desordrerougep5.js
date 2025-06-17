
var w, h
var cnv
var leftmargin, rightmargin, topmargin, bottommargin, actualheight, actualwidth, penwidth
var resolution, sourcecode

function setup() {
    w = 900
    h = 900
    cnv = createCanvas(w, h, SVG).mousePressed(savesvg);;
    centerCanvas();
    leftmargin = Math.floor(w * 0.05)
    rightmargin = Math.floor(w * 0.95)
    topmargin = Math.floor(h * 0.05)
    bottommargin = Math.floor(h * 0.95)
    actualwidth = rightmargin - leftmargin
    actualheight = bottommargin - topmargin
    colorMode(HSB, 360, 100, 100, 250);
    strokeWeight(3);
    penwidth = 0.04 * 96 // 0.04 inch is 1 mm, the width of stabilo 68/32
    resolution = Math.floor(random([3, 5, 7]))
}

function savesvg() {
    save("plein007.svg");
}

function centerCanvas() {
    var x = (windowWidth - windowHeight) / 2;
    var y = (windowHeight - windowHeight) / 2;
    cnv.position(x, y);
}


function draw() {
    background(0, 0, 100)
    noFill()
    stroke(0, 100, 100)
    vera()
    noLoop()
}

function vera() {
    var step = Math.floor(actualwidth / resolution)
    for (var i = 0; i < resolution; i++) {
        x = leftmargin + i * step
        for (var j = 0; j < resolution; j++) {
            y = topmargin + j * step
            tiltquad(x, y, step)
} } }

function tiltquad(x, y, step) {
    var off, inc, desordre, horizon
    off = 0; inc = penwidth + off; horizon = 0
    desordre = random(-3.6, 3.6); 
    push()
    translate(x, y); rotate(radians(desordre))
    for (let i = 0; i < step; i += inc) {
        line(0, horizon, step, horizon)
        horizon += inc    }
    pop()
}