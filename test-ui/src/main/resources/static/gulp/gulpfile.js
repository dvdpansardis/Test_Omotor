const gulp = require('gulp');
const requireDir = require('require-dir');
var concat = require('gulp-concat');

requireDir('./tasks');

gulp.task('default', ['browser-sync'], function () {
    
});

gulp.task('minify', function() {
  gulp.src(['./app/*.js'])
    .pipe(concat('all.js'))
    .pipe(uglify())
    .pipe(gulp.dest('./dist/'));
  gulp.src(['./app/*.css'])
  .pipe(concat('all.css'))
  .pipe(uglify())
  .pipe(gulp.dest('./dist/'));
});