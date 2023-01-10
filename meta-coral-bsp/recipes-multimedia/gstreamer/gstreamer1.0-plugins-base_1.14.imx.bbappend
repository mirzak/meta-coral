FILESEXTRAPATHS:prepend_coral-dev := "${THISDIR}/${PN}-${PV}:"

# Patches from https://coral.googlesource.com/imx-gst-plugins-base
#
# Generated using:
#
#    git format-patch rel_imx_4.14.98_2.0.0_ga..1.14.4+imx-5
SRC_URI:append_coral-dev = " \
    file://0001-Fix-NXP-s-custom-glupload-path-for-certain-formats.patch \
    file://0002-Use-highp-float-precision-only-in-YUY2-color-convert.patch \
    file://0003-Demote-buggy-FPS-prints-from-g_print-to-GST_DEBUG.patch \
    file://0004-glupload-Don-t-prealloc-any-buffers-in-dmabuf-pool.patch \
    file://0005-glupload-Fix-NXP-s-transform_caps.patch \
    file://0006-Fix-regression-of-BGRA-upload-color-channel-switched.patch \
    file://0007-gldownload-don-t-pre-allocate-ion-buffers.patch \
    file://0008-gldownload-download-RGB-BGR-and-BGRA-with-dmabuf.patch \
    file://0009-glupload-fix-double-free-of-EGLImage.patch \
    file://0010-eglimage-Fix-memory-leak.patch \
    file://0011-glimagesink-make-multiview-none-equivalent-to-mono.patch \
    file://0012-gldownload-Use-EGL-fences-instead-of-glFinish-to-syn.patch \
    file://0013-Revert-glimagesink-need-add-glFinish-after-eglswapbu.patch \
    file://0014-egl-Don-t-allocate-texture-memory-for-EGLImage.patch \
    file://0015-Allocate-cached-ION-buffers.patch \
    file://0016-fdmem-always-map-dmabuf-with-PROT_WRITE.patch \
    file://0017-Tightly-pack-RGB-buffers-downloaded-from-GPU.patch \
"
