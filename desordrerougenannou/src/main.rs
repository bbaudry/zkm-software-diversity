use std::array;

use nannou::color::Alpha;
use nannou::draw::mesh::vertex::Color;
use nannou::image::Frames;
use nannou::prelude::*;
use nannou::rand::random_range;

fn main() {
    
    nannou::sketch(view).loop_mode(LoopMode::loop_ntimes(1)).run()

}

fn view(app: &App, frame: Frame) {
    let window = app.main_window();
    let w = 900;
    let h = 900;
    let margin = 45;
    window.set_inner_size_pixels(w,h);
    let resolution   : u32 = random_range(3.0, 6.0).floor() as u32;
    let stepw = (w-margin*2)/resolution;
    let steph = (h-margin*2)/resolution;
    let penwidth = 0.04 * 96.0; // 0.04 inch is 1 mm, the width of stabilo 68/32
    let off = 2.0;
    let tilestep = penwidth+off;
    let draw = app.draw();
    draw.background().color(WHITE);  
    let draw = draw.translate(vec3(-450.0,-450.0,0.0));
    for i in 0..resolution {//(offset..w-offset).step_by(stepw as usize) 
        let x=margin+i*stepw;
        for j in 0..resolution {
            let y = margin+j*steph;
            let draw=draw.rotate(random_range(-0.02,0.02));
            for tiley in (y..y+steph).step_by(tilestep as usize) {
                draw.line()
                .start(pt2(x as f32,tiley as f32))
                .end(pt2((x+stepw) as f32,tiley as f32))
                .weight(penwidth)
                .color(hsl(0.0,1.0,0.5));
            }
        }
    }
    draw.to_frame(app, &frame).unwrap();
}

