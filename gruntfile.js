module.exports = function(grunt){
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        //individual plugin configs
        autoprefixer: {
            options: {
                browsers: ['last 3 version', 'ie 8', 'ie 9']
            },
            files: {
                src: 'WebContent/styles/base.css',
                dest: 'WebContent/styles/base.css'
            }
        },
        karma: {
            unit: {
                options: {
                    frameworks: ['jasmine'],
                    browsers: ['PhantomJS'],
                    singleRun: true,
                    files: [
                        'WebContent/vendor/angular.js',
                        'WebContent/vendor/angular-route.js',
                        'WebContent/vendor/angular-mocks.js',
                        'WebContent/scripts/**/*.js',
                        'WebContent/tests/**/*.js'
                    ],
                    reporters: ['progress']
                }
            }
        }

    });

    //load files using grunt.loadNpmTasks()
    grunt.loadNpmTasks('grunt-autoprefixer');
    grunt.loadNpmTasks('grunt-karma');

    //register custom tasks using grunt.registerTask()
    grunt.registerTask('default', ['autoprefixer']);
};