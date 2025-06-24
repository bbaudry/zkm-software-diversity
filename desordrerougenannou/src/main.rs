use std::array;

use nannou::color::Alpha;
use nannou::draw::mesh::vertex::Color;
use nannou::image::Frames;
use nannou::prelude::*;
use nannou::rand::random_range;

fn main() {
    
    nannou::sketch(view).run()
}

fn view(app: &App, frame: Frame) {
    let window = app.main_window();
    let w = 900;
    let h = 900;
    let offset = 45;
    window.set_inner_size_pixels(w,h);
    let resolution = 3;//  : u32 = random_range(3.0, 5.0).floor() as u32;
    let stepw = (w-offset*2)/resolution;
    let steph = (h-offset*2)/resolution;
    let penwidth = 0.04 * 96.0; // 0.04 inch is 1 mm, the width of stabilo 68/32
    let off = 0.2;
    let tilestep = penwidth+off;
    let draw = app.draw();
    draw.background().color(WHITE);    
    draw.ellipse().color(STEELBLUE);
    let draw = draw.translate(vec3(-450.0,-450.0,0.0));
    for x in (offset..w-offset).step_by(stepw as usize) {
        for y in (offset..h-offset).step_by(steph as usize) {
            let draw=draw.rotate(-3.0)
            for tiley in (y..y+steph-offset).step_by(tilestep as usize) {
                draw.line()
                .start(pt2(x as f32,tiley as f32))
                .end(pt2((x+stepw-offset) as f32,tiley as f32))
                .weight(1.23)
                .color(hsl(0.0,1.0,0.5));
            }
            let draw=draw.rotate(3.0)
        }
    }
    draw.to_frame(app, &frame).unwrap();
}

