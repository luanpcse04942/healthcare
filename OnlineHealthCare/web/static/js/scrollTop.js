document.addEventListener("DOMContentLoaded", function () {
    var scrollToTopBtn = document.getElementById("scrollToTopBtn");
    var rootElement = document.documentElement;

    function scrollToTop() {
//		// Scroll to top logic
//		rootElement.scrollTo({
//			top: 0,
//			behavior: "smooth"
//		});
        var target = document.getElementById("move-top");
        var scrollContainer = target;
        do { //find scroll container
            scrollContainer = scrollContainer.parentNode;
            if (!scrollContainer)
                return;
            scrollContainer.scrollTop += 1;
        } while (scrollContainer.scrollTop === 0);

        var targetY = 0;
        do { //find the top of target relatively to the container
            if (target === scrollContainer)
                break;
            targetY += target.offsetTop;
        } while (target === target.offsetParent);

        scroll = function (c, a, b, i) {
            i++;
            if (i > 30)
                return;
            c.scrollTop = a + (b - a) / 30 * i;
            setTimeout(function () {
                scroll(c, a, b, i);
            }, 20);
        }
        // start scrolling
        scroll(scrollContainer, scrollContainer.scrollTop, targetY, 0);
    }
    scrollToTopBtn.addEventListener("click", scrollToTop);

    window.addEventListener("scroll", function () {

        myID = document.getElementById("scrollToTopBtn");

        var myScrollFunc = function () {
            var y = window.scrollY;
            if (y >= 100) {
                myID.className = "scrollToTopBtn show"
            } else {
                myID.className = "scrollToTopBtn hide"
            }
        };

        myScrollFunc();
    });
});
