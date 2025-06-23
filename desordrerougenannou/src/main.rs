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
    window.set_inner_size_pixels(900,900);
    let draw = app.draw();
    draw.background().color(WHITE);
    draw.ellipse().color(STEELBLUE);
    draw.line()
        .start(pt2(-100.0,0.0))
        .end(pt2(100.0,0.0))
        .weight(1.23)
        .color(hsl(0.0,1.0,0.5));

    draw.to_frame(app, &frame).unwrap();
}
