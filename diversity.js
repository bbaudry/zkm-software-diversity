
var w, h
var cnv
var leftmargin, rightmargin, topmargin, bottommargin, actualheight, actualwidth, penwidth
var stepw, steph, resolution
var grid = []

function setup() {
    w = windowWidth * 0.8
    h = windowHeight * 0.9
    cnv = createCanvas(w, h);
    centerCanvas();
    colorMode(HSB, 360, 100, 100, 250);
    resolution = 10
    stepw = w / resolution
    steph = h / resolution
}

function centerCanvas() {
    var x = (windowWidth - w) * 0.5;
    var y = (windowHeight - h) * 0.5;
    cnv.position(x, y);
}


function draw() {
    background(0, 0, 0)
    initgrid()
    showedges()
    shownodes()
    noLoop()
}

function initgrid() {
    let x, y, xnode, ynode, offset
    offset = steph * 0.2
    for (let i = 0; i < resolution; i++) {
        x = i * stepw
        for (let j = 0; j < resolution; j++) {
            y = j * steph
            xnode = x + offset + random() * (stepw - (offset * 2))
            ynode = y + offset + random() * (steph - (offset * 2))
            grid.push(createVector(xnode, ynode))
        }
    }
}

function shownodes() {
    let diam = steph * 0.3
    for (i in grid) {
        noStroke()
        fill(0, 0, 100)
        ellipse(grid[i].x, grid[i].y, diam, diam)
    }
}

function shownodesdiversified() {
    let diam = steph * 0.3
    let col
    for (i in grid) {
        noStroke()
        col=Math.floor(random(3))
        switch(col){
            case 0: fill(0, 0, 100); break;
            case 1: fill(0, 100, 100); break;
            case 2: fill(180, 100, 100); break;
        }
        
        ellipse(grid[i].x, grid[i].y, diam, diam)
    }
}


function showedges() {
    stroke(0,0,100)
    let chance=0.5
    for(let i=0; i<grid.length; i++){
        x = grid[i].x
        y = grid[i].y
        if (i%resolution != 0 && i%resolution!=resolution-1 && i>resolution && i< resolution * (resolution-1)) {
            if (random()>chance){edge(x, y, i, "east")}
            edge(x, y, i, "southeast")
            if (random()>chance){edge(x, y, i, "south")}
            if (random()>chance){edge(x, y, i, "northeast")}
            if (random()>chance){edge(x, y, i, "north")}
            if (random()>chance){edge(x, y, i, "west")}
            if (random()>chance){edge(x, y, i, "southwest")}
            edge(x, y, i, "northwest")
        }
    }
}

function edge(x, y, i, direction) {
    switch (direction) {
        case "west": line(x, y, grid[i - resolution].x, grid[i - resolution].y)
            break;
        case "southwest": line(x, y, grid[i + 1 - resolution].x, grid[i + 1 - resolution].y)
            break;
        case "south": line(x, y, grid[i + 1].x, grid[i + 1].y)
            break;
        case "southeast": line(x, y, grid[i + 1 + resolution].x, grid[i + 1 + resolution].y)
            break;
        case "east": line(x, y, grid[i + resolution].x, grid[i + resolution].y)
            break;
        case "northeast": line(x, y, grid[i - 1 + resolution].x, grid[i - 1 + resolution].y)
            break;
        case "north": line(x, y, grid[i - 1].x, grid[i - 1].y)
            break;
        case "northwest": line(x, y, grid[i - 1 - resolution].x, grid[i - 1 - resolution].y)
            break;
    }
}

function mouseClicked() {
  shownodesdiversified()
} 