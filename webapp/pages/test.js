import BMF from 'browser-md5-file';

const el = document.getElementById('upload');
const bmf = new BMF();

el.addEventListener('change', handle, false);

function handle(e) {
    const file = e.target.files[0];
    bmf.md5(
        file,
        (err, md5) => {
            console.log('err:', err);
            console.log('md5 string:', md5); // 97027eb624f85892c69c4bcec8ab0f11
        },
        progress => {
            console.log('progress number:', progress);
        },
    );
}
