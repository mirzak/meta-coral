FILESEXTRAPATHS_prepend_coral-dev := "${THISDIR}/${PN}-${PV}:"

# Patches from https://coral.googlesource.com/imx-gst1.0-plugin
#
# These patches where extracted manually, the branch does not seem to be a clean
# fork of upstream
SRC_URI_append_coral-dev = "\
    file://0001-Silence-NXP-stdout-prints.patch \
    file://0002-Require-vpudec-jpeg-input-to-be-parsed.patch \
    file://0003-Never-re-allocate-buffer-pool-if-caps-haven-t-change.patch \
    file://0004-Reduce-default-number-of-extra-decoder-output-buffer.patch \
    file://0005-Fix-cropping-support-to-work-like-rest-of-GStreamer.patch \
    file://0006-vpudec-Report-an-error-instead-of-segfaulting-on-new.patch \
    file://0007-vpudec-Remove-log-statement-that-segfaults.patch \
    file://0008-Disable-NXP-adaptive-frame-drop-by-default.patch \
"
