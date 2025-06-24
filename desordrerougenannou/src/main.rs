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
    let resolution = 3;
    let step = w/3;
    window.set_inner_size_pixels(w,h);
    let draw = app.draw();
    draw.background().color(WHITE);    
    draw.ellipse().color(STEELBLUE);
    let draw = draw.translate(vec3(-450.0,0.0,0.0));

    for y in (-450..451).step_by(300) {
        //if y%3==0 {
            draw.line()
            .start(pt2(-100.0,y as f32))
            .end(pt2(100.0,y as f32))
            .weight(1.23)
            .color(hsl(0.0,1.0,0.5));
        //}
    }
    draw.to_frame(app, &frame).unwrap();
}
